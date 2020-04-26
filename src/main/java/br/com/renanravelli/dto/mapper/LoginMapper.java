package br.com.renanravelli.dto.mapper;

import br.com.renanravelli.domain.Usuario;
import br.com.renanravelli.dto.LoginDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {SolicitacaoMapper.class})
public interface LoginMapper {

    LoginDTO toDTO(Usuario usuario);

}
