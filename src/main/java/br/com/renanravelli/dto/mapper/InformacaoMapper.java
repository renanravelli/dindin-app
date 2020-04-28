package br.com.renanravelli.dto.mapper;

import br.com.renanravelli.domain.Informacao;
import br.com.renanravelli.dto.InformacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author renanravelli
 */

@Mapper(componentModel = "spring", uses = {SolicitacaoMapper.class, EnderecoMapper.class})
public interface InformacaoMapper {

    InformacaoMapper INSTANCE = Mappers.getMapper(InformacaoMapper.class);

    Informacao fromDTO(InformacaoDTO informacaoDTO);

    InformacaoDTO toDTO(Informacao informacao);
}
