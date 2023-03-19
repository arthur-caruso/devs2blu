package servivo;

public class SerVivo {
    private String reino, filo, classe, ordem, familia, genero, especie;

	public SerVivo() {}

	public SerVivo(	String reino,
					String filo,
					String classe,
					String ordem,
					String familia,
					String genero,
					String especie) {  
		this.reino = reino;
		this.filo = filo;
		this.classe = classe;
		this.ordem = ordem;
		this.familia = familia;
		this.genero = genero;
		this.especie = especie;
	}

	public String toString() {
		return	reino + ", " +
				filo + ", " +
				classe + ", " +
				ordem + ", " +
				familia + ", " +
				genero + ", " +
				especie;
	}

	public void setReino(String reino)		{ this.reino = reino; }
	public void setFilo(String filo)		{ this.filo = filo; }
	public void setClasse(String classe)	{ this.classe = classe; }
	public void setOrdem(String ordem)		{ this.ordem = ordem; }
	public void setFamilia(String familia)	{ this.familia = familia; }
	public void setGenero(String genero)	{ this.genero = genero; }
	public void setEspecie(String especie)	{ this.especie = especie; }

	public String getReino()	{ return reino; }
	public String getFilo()		{ return filo; }
	public String getClasse()	{ return classe; }
	public String getOrdem()	{ return ordem; }
	public String getFamilia()	{ return familia; }
	public String getGenero()	{ return genero; }
	public String getEspecie()	{ return especie; }

}