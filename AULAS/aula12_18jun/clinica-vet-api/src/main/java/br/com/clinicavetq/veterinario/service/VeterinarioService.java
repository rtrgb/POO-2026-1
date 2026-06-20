package br.com.clinicavetq.veterinario.service;

import java.util.ArrayList;
import java.util.List;

import br.com.clinicavetq.veterinario.dto.EnderecoDTO;
import br.com.clinicavetq.veterinario.dto.VeterinarioPatchDTO;
import br.com.clinicavetq.veterinario.dto.VeterinarioRequestDTO;
import br.com.clinicavetq.veterinario.dto.VeterinarioResponseDTO;
import br.com.clinicavetq.veterinario.model.Endereco;
import br.com.clinicavetq.veterinario.model.Veterinario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class VeterinarioService {

    @Transactional
    public VeterinarioResponseDTO cadastrar(
            VeterinarioRequestDTO dto) {

        if (Veterinario.existsByCpf(dto.cpf())) {
            throw new IllegalArgumentException(
                    "CPF já cadastrado.");
        }

        if (Veterinario.existsByCrmv(dto.crmv())) {
            throw new IllegalArgumentException(
                    "CRMV já cadastrado.");
        }

        if (Veterinario.existsByEmail(dto.email())) {
            throw new IllegalArgumentException(
                    "Email já cadastrado.");
        }

        Veterinario veterinario = new Veterinario();

        veterinario.nome = dto.nome();
        veterinario.cpf = dto.cpf();
        veterinario.crmv = dto.crmv();
        veterinario.email = dto.email();
        veterinario.telefone = dto.telefone();
        veterinario.especialidade = dto.especialidade();

        Endereco endereco = new Endereco();
        endereco.cep = dto.endereco().cep();
        endereco.rua = dto.endereco().rua();
        endereco.numero = dto.endereco().numero();
        endereco.complemento = dto.endereco().complemento();
        endereco.bairro = dto.endereco().bairro();
        endereco.cidade = dto.endereco().cidade();
        endereco.estado = dto.endereco().estado();

        veterinario.endereco = endereco;

        veterinario.persist();

        return montarResponse(veterinario);
    }

    public List<VeterinarioResponseDTO> listar() {

        List<VeterinarioResponseDTO> lista = new ArrayList<>();

        List<Veterinario> veterinarios = Veterinario.listAll();

        for (Veterinario v : veterinarios) {
            lista.add(montarResponse(v));
        }

        return lista;
    }

    public VeterinarioResponseDTO buscarPorId(Long id) {

    	Veterinario veterinario = Veterinario.findVeterinarioById(id)
    	        .orElseThrow(() -> new NotFoundException("Veterinário não encontrado."));

        return montarResponse(veterinario);
    }

    private VeterinarioResponseDTO montarResponse(
            Veterinario veterinario) {

        EnderecoDTO enderecoDTO =
                new EnderecoDTO(
                        veterinario.endereco.cep,
                        veterinario.endereco.rua,
                        veterinario.endereco.numero,
                        veterinario.endereco.complemento,
                        veterinario.endereco.bairro,
                        veterinario.endereco.cidade,
                        veterinario.endereco.estado
                );

        return new VeterinarioResponseDTO(
                veterinario.id,
                veterinario.nome,
                veterinario.cpf,
                veterinario.crmv,
                veterinario.email,
                veterinario.telefone,
                veterinario.especialidade,
                enderecoDTO
        );
    }

    @Transactional
    public VeterinarioResponseDTO atualizarParcial(
            Long id,
            VeterinarioPatchDTO dto) {

        Veterinario veterinario = Veterinario.findVeterinarioById(id)
                .orElseThrow(() -> new NotFoundException("Veterinário não encontrado."));

        if (dto.nome() != null) {
            veterinario.nome = dto.nome();
        }

        if (dto.cpf() != null) {
            if (!dto.cpf().equals(veterinario.cpf)
                    && Veterinario.existsByCpf(dto.cpf())) {
                throw new IllegalArgumentException("CPF já cadastrado.");
            }

            veterinario.cpf = dto.cpf();
        }

        if (dto.crmv() != null) {
            if (!dto.crmv().equals(veterinario.crmv)
                    && Veterinario.existsByCrmv(dto.crmv())) {
                throw new IllegalArgumentException("CRMV já cadastrado.");
            }

            veterinario.crmv = dto.crmv();
        }

        if (dto.email() != null) {
            if (!dto.email().equals(veterinario.email)
                    && Veterinario.existsByEmail(dto.email())) {
                throw new IllegalArgumentException("Email já cadastrado.");
            }

            veterinario.email = dto.email();
        }

        if (dto.telefone() != null) {
            veterinario.telefone = dto.telefone();
        }

        if (dto.especialidade() != null) {
            veterinario.especialidade = dto.especialidade();
        }

        if (dto.endereco() != null) {

            if (dto.endereco().cep() != null) {
                veterinario.endereco.cep = dto.endereco().cep();
            }

            if (dto.endereco().rua() != null) {
                veterinario.endereco.rua = dto.endereco().rua();
            }

            if (dto.endereco().numero() != null) {
                veterinario.endereco.numero = dto.endereco().numero();
            }

            if (dto.endereco().complemento() != null) {
                veterinario.endereco.complemento = dto.endereco().complemento();
            }

            if (dto.endereco().bairro() != null) {
                veterinario.endereco.bairro = dto.endereco().bairro();
            }

            if (dto.endereco().cidade() != null) {
                veterinario.endereco.cidade = dto.endereco().cidade();
            }

            if (dto.endereco().estado() != null) {
                veterinario.endereco.estado = dto.endereco().estado();
            }
        }

        return montarResponse(veterinario);
    }
    

    @Transactional
    public void remover(Long id) {

        Veterinario veterinario = Veterinario.findVeterinarioById(id)
                .orElseThrow(() -> new NotFoundException("Veterinário não encontrado."));

        veterinario.delete();
    }
	
	
	
}