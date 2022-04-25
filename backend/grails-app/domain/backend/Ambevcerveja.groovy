package backend

class Ambevcerveja {
    String nome
	String marca
	String tipo
    
	static constraints = {
	    nome inList: ['Skol', 'Brahma', 'Bohemia', 'Antartica']
    }
}
