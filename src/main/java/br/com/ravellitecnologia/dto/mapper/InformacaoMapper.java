package br.com.ravellitecnologia.dto.mapper;

import br.com.ravellitecnologia.domain.Informacao;
import br.com.ravellitecnologia.dto.InformacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author renanravelli
 */

@Mapper(componentModel = "spring", uses = {SolicitacaoMapper.class})
public interface InformacaoMapper {

    InformacaoMapper INSTANCE = Mappers.getMapper(InformacaoMapper.class);

    Informacao fromDTO(InformacaoDTO informacaoDTO);

    InformacaoDTO toDTO(Informacao informacao);
}
