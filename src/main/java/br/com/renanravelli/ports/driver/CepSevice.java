package br.com.renanravelli.ports.driver;

import br.com.renanravelli.dto.ViaCep;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author renanravelli
 */

@FeignClient(name = "cepSevice", url = "https://viacep.com.br/ws")
public interface CepSevice {

    @GetMapping("/{cep}/json")
    ViaCep getEndereco(@PathVariable("cep") String cep);
}
