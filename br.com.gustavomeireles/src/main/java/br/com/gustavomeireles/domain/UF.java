package br.com.gustavomeireles.domain;


	public enum UF {
		AC("AC", "Acre"), 
		AL("AL", "Alagoas"),
		AM("AM", "Amazonas"),
		BA("BA", "Bahia"),
		CE("CE", "Ceará"),
		DF("DF", "Distrito Federal"),
		ES("ES", "Espirito Santo"),
		GO("GO", "Goiás"),
		MA("MA", "Maranhao"),
		MT("MT", "Mato Grosso"),
		MS("MS", "Mato Grosso do Sul"),
		MG("MG", "Minas Gerais"),
		PA("PA", "Parána"),
		PB("PB", "Paraiba"),
		PR("PR", "Paraná"),
		PE("PE", "Pernambuco"),
		PI("PI", "Piauí"),
		RJ("RJ", "Rio de Janeiro"),
		RN("RN", "Rio Grande do Norte"),
		RS("RS", "Rio Grande do Sul"),
		RO("RO", "Rondónia"),
		RR("RR", "Roraima"),
		SC("SC", "Santa Catarina"),
		SP("SP", "Sao Paulo"),
		SE("SE", "Sergipe"),
		TO("TO", "Tocantins");
		private UF(String sigla, String descricao) {
			this.sigla = sigla;
			this.descricao = descricao;
		}
		private String sigla;
		private String descricao;
		
		public String getSigla() {
			return sigla;
		}
		public void setSigla(String sigla) {
			this.sigla = sigla;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

	}
	