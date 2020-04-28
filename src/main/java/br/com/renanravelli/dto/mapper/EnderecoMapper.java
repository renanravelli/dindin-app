package br.com.renanravelli.dto.mapper;

import br.com.renanravelli.domain.Endereco;
import br.com.renanravelli.dto.EnderecoDTO;
import br.com.renanravelli.dto.ViaCep;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author renanravelli
 */

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);

    Endereco fromDTO(EnderecoDTO enderecoDTO);

    EnderecoDTO toDTO(Endereco endereco);

    @Mapping(source = "logradouro", target = "endereco")
    @Mapping(source = "localidade", target = "cidade")
    @Mapping(source = "uf", target = "estado")
    Endereco fromViaCep(ViaCep viaCep);
}
