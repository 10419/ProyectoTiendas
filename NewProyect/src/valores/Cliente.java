package valores;

 

public class Cliente extends Persona{
    
    private String cliente_id;
    private String cliente_tipo;    
    private String cliente_persona_id;

    public String getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(String cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getCliente_tipo() {
        return cliente_tipo;
    }

    public void setCliente_tipo(String cliente_tipo) {
        this.cliente_tipo = cliente_tipo;
    }

    public String getCliente_persona_id() {
        return cliente_persona_id;
    }

    public void setCliente_persona_id(String cliente_persona_id) {
        this.cliente_persona_id = cliente_persona_id;
    }
    
    /*
    public static void main(String[] args) {
     Cliente cl = new Cliente();
     cl.setNombre("");
    }    
    */
}