using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace WindowsFormsApplication1
{
    class ControladorOperaciones
    {
        /*
         * Atributo que captura la operación
         */
        private String sender;
        /* Atributo desde el que llamamos al panel que modifica los valores de este
         */
        private PanelCalculadora panel;

        /*
         * Constructor principal que inicializa el evento de la operación
         */
        public ControladorOperaciones(String sender, PanelCalculadora panel)
        {
            this.sender = sender;
            this.panel = panel;
            iniciaEvento();
        }

        /*
         * Método que inicializa la operación
         */
        public void iniciaEvento()
        {
            if(sender.Equals("="))
            {
                calculaFuncion();
            }
            else if (sender.Equals("+/-"))
            {
                panel.setAux(new Numero(panel.getPantalla()).getNum());
                Numero aux2 = new Numero(panel.getAux());
                aux2.multiplicar(-1);
                panel.setAux(aux2.getNum());
                compruebaError();
                if (!panel.getErrDecimal())
                    panel.setPantalla("" + panel.getAux());
                panel.setErrDecimal(false);
            } else {
                panel.setOperacion(sender);
                if ((panel.getAux() != 0) && !panel.getOp())
                {
                    calculaFuncion();
                }
                else
                {
                    panel.setAux(new Numero(panel.getPantalla()).getNum());
                }
			}
            panel.setOp(true);
        }

        /*
         * Método que calcula la operación llevada a cabo
         */
        public void calculaFuncion()
        {
            if (panel.getOperacion().Equals("+"))
            {
                Numero aux2 = new Numero(panel.getAux());
                aux2.sumar(new Numero(panel.getPantalla()).getNum());
                panel.setAux(aux2.getNum());
            }
            else if (panel.getOperacion().Equals("-"))
            {
                Numero aux2 = new Numero(panel.getAux());
                aux2.restar(new Numero(panel.getPantalla()).getNum());
                panel.setAux(aux2.getNum());
            }
            else if (panel.getOperacion().Equals("/"))
            {
                Numero aux2 = new Numero(panel.getAux());
                aux2.dividir(new Numero(panel.getPantalla()).getNum());
                panel.setAux(aux2.getNum());
            }
            else if (panel.getOperacion().Equals("*"))
            {
                Numero aux2 = new Numero(panel.getAux());
                aux2.multiplicar(new Numero(panel.getPantalla()).getNum());
                panel.setAux(aux2.getNum());
            }
            else if (panel.getOperacion().Equals("%"))
            {
                Numero aux2 = new Numero(panel.getAux());
                aux2.modulo(new Numero(panel.getPantalla()).getNum());
                panel.setAux(aux2.getNum());
            }
            compruebaError();
            if (!panel.getErrDecimal())
                panel.setPantalla("" + panel.getAux());
            panel.setErrDecimal(false);
            panel.setOperacion("");
            if (sender.Equals("="))
            {
                panel.setAux(0);
            }
        }

        /*
         * Método que comprueba el error de operaciones
         */
        public void compruebaError()
        {
            String respuesta = "" + panel.getAux();
            if (respuesta.Equals("Infinito") || respuesta.Equals("NeuN"))
            {
                MessageBox.Show(panel, "Error, no se puede dividir entre 0", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                panel.setAux(0);
                respuesta = "" + panel.getAux();
            }
            if (respuesta.EndsWith(",0"))
            {
                panel.setErrDecimal(true);
                respuesta = respuesta.Substring(0, respuesta.Length - 2);
                panel.setPantalla("" + respuesta);
            }
        }
    }
}
