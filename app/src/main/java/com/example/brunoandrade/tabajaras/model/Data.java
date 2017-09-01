
package com.example.brunoandrade.tabajaras.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Data implements Serializable{

    @SerializedName("operador")
    private String operadora;

    @SerializedName("dataSolicitacao")
    private long dataSolicitacao;

    @SerializedName("idCaixa")
    private String  idCaixa;

    @SerializedName("matriculaUsuario")
    private String matriculaUsuario;

    @SerializedName("vendasListMessage")
    private List<VendasM> vendasM = null;


    public Data(String operadora, long dataSolicitacao, String idCaixa, String matriculaUsuario, List<VendasM> vendasM) {
        this.operadora = operadora;
        this.dataSolicitacao = dataSolicitacao;
        this.idCaixa = idCaixa;
        this.matriculaUsuario = matriculaUsuario;
        this.vendasM = vendasM;
    }

    public String getMatriculaUsuario() {
        return matriculaUsuario;
    }

    public void setMatriculaUsuario(String matriculaUsuario) {
        this.matriculaUsuario = matriculaUsuario;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public long getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(long dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public String getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(String idCaixa) {
        this.idCaixa = idCaixa;
    }

    public List<VendasM> getVendasM() {
        return vendasM;
    }

    public void setVendasM(List<VendasM> vendasM) {
        this.vendasM = vendasM;
    }
}
