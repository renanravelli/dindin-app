package br.com.ravellitecnologia.dto.mapper;

import br.com.ravellitecnologia.domain.Solicitacao;
import br.com.ravellitecnologia.dto.SolicitacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;

/**
 * @author renanravelli
 */

@Mapper(componentModel = "spring")
public interface SolicitacaoMapper {

    SolicitacaoMapper INSTANCE = Mappers.getMapper(SolicitacaoMapper.class);

    Set<Solicitacao> fromDTO(Set<SolicitacaoDTO> solicitacaoDTO);

    Solicitacao fromDTO(SolicitacaoDTO solicitacaoDTO);

    Set<SolicitacaoDTO> toDTO(Set<Solicitacao> solicitacao);

    SolicitacaoDTO toDTO(Solicitacao solicitacao);
}
