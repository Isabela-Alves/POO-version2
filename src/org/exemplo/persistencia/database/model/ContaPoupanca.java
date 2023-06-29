package org.exemplo.persistencia.database.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import org.exemplo.persistencia.database.model.IConta;

public class ContaPoupanca implements Serializable, IConta { //ainda nao entendi esse erro

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer numeroConta;
	private BigDecimal saldo;
	private LocalDateTime dataAbertura;
	private boolean status;
	private List<RegistroTransacao> transacoes;//ainda nao tem

	public ContaPoupanca() {
		this.numeroConta = new Random().nextInt(999999999);
		this.saldo = BigDecimal.ZERO;
		saldo.setScale(4, RoundingMode.HALF_UP);
		this.dataAbertura = LocalDateTime.now();
		this.status = true;
		transacoes = new ArrayList<>();//nao tem
	}

	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}


	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<RegistroTransacao> getTransacoes() {
		return transacoes; //nop
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroConta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaPoupanca other = (ContaPoupanca) obj;
		return Objects.equals(numeroConta, other.getNumeroConta());
	}

	@Override
	public String toString() {
		return "Conta Poupança [numeroConta=" + numeroConta + ", saldo=" + saldo + ", dataAbertura=" + dataAbertura
				+ ", status=" + status + "]";
	}
	
	 @Override //ta na mesma cituacao de contaCorrente,deixar assim ou pegar do antigo
	    public void depositar(BigDecimal quantia) {
	        if (quantia.compareTo(BigDecimal.ZERO) <= 0) {
	            throw new IllegalArgumentException("O valor de depósito deve ser maior que zero.");
	        }

	        saldo = saldo.add(quantia);
	    }

	    @Override
	    public void transferir(IConta destino, BigDecimal quantia) {
	        if (quantia.compareTo(BigDecimal.ZERO) <= 0) {
	            throw new IllegalArgumentException("O valor de transferência deve ser maior que zero.");
	        }

	        if (quantia.compareTo(saldo) > 0) {
	            throw new IllegalArgumentException("Saldo insuficiente para realizar a transferência.");
	        }

	        sacar(quantia);
	        contaDestino.depositar(quantia);
	        //resolver esse bagulho ainda,se vai ter ou nao
	    }
	}
		

	

