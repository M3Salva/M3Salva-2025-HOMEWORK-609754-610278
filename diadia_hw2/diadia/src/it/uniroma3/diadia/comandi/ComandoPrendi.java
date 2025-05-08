package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	private IO io;
	private String nomeAttrezzo;
	private final static String NOME = "prendi";

	
	@Override
	public void esegui(Partita partita) {
		Attrezzo a = partita.getLabirinto().getStanzaCorrente().getAttrezzo(this.nomeAttrezzo);
		
		if(a == null)
			io.mostraMessaggio("L'attrezzo " + this.nomeAttrezzo + " non è presente nella stanza " + partita.getStanzaCorrente().getNome());
		else {
			if(partita.getStanzaCorrente().hasAttrezzo(this.nomeAttrezzo)) {
				if(partita.getGiocatore().getBorsa().getPesoRimanente(a)) {
					partita.getGiocatore().getBorsa().addAttrezzo(a);
					partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
					io.mostraMessaggio("Hai preso l'attrezzo " + this.nomeAttrezzo);
				} 
				else {
					io.mostraMessaggio("Attrezzo troppo pesante per entrare nella borsa!");
				}
			}
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo  = parametro;

	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}
	
	@Override
	public String getNome() {
		return NOME;
	}

}
