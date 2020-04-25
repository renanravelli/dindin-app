package br.com.ravellitecnologia.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Mensagem {

    DADOS_DO_USUARIO_NAO_INFORMADO("Os dados do usu\u00E1rio n\u00E3o foram informados."),
    DADOS_DO_SABOR_NAO_INFORMADO("Os dados do sabor n\u00E3o foram informados."),
    DADOS_DA_SOLICITACAO_NAO_INFORMADO("Os dados da solicita\u00E7\u00E3o n\u00E3o foram informados."),
    DADOS_DO_ESTOQUE_NAO_INFORMADO("Os dados do estoque n\u00E3o foram informados."),
    USUARIO_NAO_ENCONTRADO("Usu\u00E1rio n\u00E3o localizado."),
    SOLICITACAO_NAO_ENCONTRADA("Solicita\u00E7\u00E3o n\u00E3o localizada."),
    SABOR_NAO_ENCONTRADO("Sabor n\u00E3o localizado."),
    ESTOQUE_NAO_ENCONTRADO("Estoque n\u00E3o localizado."),
    QUANTIDADE_NAO_INFORMADO("Quantidade n\u00E3o inforamda."),
    QUANTIDADE_NAO_SUFICIENTE("N\u00E3o cont\u00E9m quantidade suficitente no estoque."),
    PAGAMENTO_NAO_EFETUADO("Pagamento n\u00E3o efetuado."),
    PAGAMENTO_JA_EFETUADO("Pagamento j\u00E1 efetuado."),
    SOLICITACAO_CANCELADA("Solicita\u00E7\u00E3o j\u00E1 foi cancelada."),
    SOLICITACAO_FINALIZADA("Solicita\u00E7\u00E3o j\u00E1 foi finalizada."),
    USUARIO_JA_CADASTRADO("O usu\u00E1rio informado j\u00E1 cadastrado."),
    DOCUMENTO_JA_CADASTRADO("O documento informado j\u00E1 cadastrado."),
    EMAIL_JA_CADASTRADO("O e-mail informado j\u00E1 cadastrado."),
    SABOR_EM_ESTOQUE("Estoque ainda disponível.");

    private final String mensagem;
}
