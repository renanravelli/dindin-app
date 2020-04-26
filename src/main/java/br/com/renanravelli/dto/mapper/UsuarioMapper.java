package br.com.renanravelli.dto.mapper;

import br.com.renanravelli.domain.Usuario;
import br.com.renanravelli.dto.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author renanravelli
 */

@Mapper(componentModel = "spring", uses = InformacaoMapper.class)
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    Usuario fromDTO(UsuarioDTO usuarioDTO);

    UsuarioDTO toDTO(Usuario usuario);
}
