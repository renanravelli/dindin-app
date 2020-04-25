package br.com.ravellitecnologia.dto.mapper;

import br.com.ravellitecnologia.domain.Usuario;
import br.com.ravellitecnologia.dto.LoginDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {SolicitacaoMapper.class})
public interface LoginMapper {

    LoginDTO toDTO(Usuario usuario);

}
