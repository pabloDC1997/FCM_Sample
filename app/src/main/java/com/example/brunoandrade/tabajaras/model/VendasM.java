
package com.example.brunoandrade.tabajaras.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class VendasM implements Serializable {

    @SerializedName("protocoloNfce")
    private String protocoloNfce;

    @SerializedName("numeroCupomNfce")
    private String numeroCupomNfce;

    @SerializedName("tipoEmissaoNfce")
    private String tipoEmissaoNfce;

    @SerializedName("numeroLancamentoVenda")
    private String numeroLancamentoVenda;

    @SerializedName("valorCompra")
    private double valorCompra;

    @SerializedName("dataCompra")
    private long dataCompra;

    public String getProtocoloNfce() {
        return protocoloNfce;
    }

    public void setProtocoloNfce(String protocoloNfce) {
        this.protocoloNfce = protocoloNfce;
    }

    public String getNumeroCupomNfce() {
        return numeroCupomNfce;
    }

    public void setNumeroCupomNfce(String numeroCupomNfce) {
        this.numeroCupomNfce = numeroCupomNfce;
    }

    public String getTipoEmissaoNfce() {
        return tipoEmissaoNfce;
    }

    public void setTipoEmissaoNfce(String tipoEmissaoNfce) {
        this.tipoEmissaoNfce = tipoEmissaoNfce;
    }

    public String getNumeroLancamentoVenda() {
        return numeroLancamentoVenda;
    }

    public void setNumeroLancamentoVenda(String numeroLancamentoVenda) {
        this.numeroLancamentoVenda = numeroLancamentoVenda;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public long getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(long dataCompra) {
        this.dataCompra = dataCompra;
    }

}
