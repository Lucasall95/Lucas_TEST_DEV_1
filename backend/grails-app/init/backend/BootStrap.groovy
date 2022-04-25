package backend

class BootStrap {
    
	Ambevcerveja cerveja
	
    def init = { servletContext ->
	    cerveja.save('Skol Puro Malte', 'Skol', 'Puro Malte').save()
		cerveja.save('Brahma zero', 'Brahma', 'Larger').save()
		cerveja.save('Antartica Original', 'Antartica', 'Pilsen').save()
    }
    def destroy = {
    }
}
