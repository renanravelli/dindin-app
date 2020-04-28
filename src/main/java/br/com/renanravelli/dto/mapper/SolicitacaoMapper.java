package br.com.renanravelli.dto.mapper;

import br.com.renanravelli.domain.Solicitacao;
import br.com.renanravelli.dto.SolicitacaoDTO;
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

    @Mapping(source = "status.descricao", target = "status")
    @Mapping(source = "formaPagamento.descricao", target = "formaPagamento")
    SolicitacaoDTO toDTO(Solicitacao solicitacao);
}
