package ejer1_13;

/**
 *
 * @author Mohammed
 */
public class Respuesta
{

    private boolean respuestaCorrecta;
    private boolean enTiempo;

    public Respuesta(boolean respuestaCorrecta, boolean enTiempo)
    {
        this.respuestaCorrecta = respuestaCorrecta;
        this.enTiempo = enTiempo;

    }

    public boolean isRespuestaCorrecta()
    {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(boolean respuestaCorrecta)
    {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public boolean isEnTiempo()
    {
        return enTiempo;
    }

    public void setEnTiempo(boolean enTiempo)
    {
        this.enTiempo = enTiempo;
    }

}
