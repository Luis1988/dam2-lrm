package hibernate.relaciones.unouno.modelo;
import java.io.Serializable;
public class Presidente implements Serializable
{
    private int id;
    private String nombre;
    private Pais pais;

    public Presidente()
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

    public Pais getPais()
    {
        return pais;
    }

    public void setPais(Pais pais)
    {
        this.pais = pais;
    }
}