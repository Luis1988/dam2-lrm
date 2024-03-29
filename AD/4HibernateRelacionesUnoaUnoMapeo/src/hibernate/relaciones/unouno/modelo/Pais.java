package hibernate.relaciones.unouno.modelo;
import java.io.Serializable;
public class Pais implements Serializable
{
    private int id;
    private String nombre;
    private Presidente presidente;

    public Pais()
    {
    }

    public int getId()
    {
        return id;
    }

    protected void setId(int id)
    {
        this.id = id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public Presidente getPresidente()
    {
        return presidente;
    }

    public void setPresidente(Presidente presidente)
    {
        this.presidente = presidente;
        presidente.setPais(this);
    }
}