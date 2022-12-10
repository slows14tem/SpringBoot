package edu.pnu.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Logs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	private String method;
	private String sql;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date regidate;
	private boolean success;
	
	public Logs() {
		// TODO Auto-generated constructor stub
	}

	public Logs(String method, String sql, boolean success) {
		super();
		this.method = method;
		this.sql = sql;
		regidate = new Date();
		this.success = success;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public Date getRegidate() {
		return regidate;
	}

	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "Logs [seq=" + seq + ", method=" + method + ", sql=" + sql + ", regidate=" + regidate + ", success="
				+ success + "]";
	}
	
	
}
