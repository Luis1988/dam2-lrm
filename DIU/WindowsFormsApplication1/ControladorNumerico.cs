using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace WindowsFormsApplication1
{
    class ControladorNumerico
    {
        /*
         * Valor que captura el evento
         */
        private String sender;
        /*
         * Panel desde el que controlamos los eventos y modificamos sus valores
         */
        private PanelCalculadora panel;

        /*
         * Contructor principal de la clase que inicializa el evento
         */
        public ControladorNumerico(String sender, PanelCalculadora panel)
        {
            this.sender = sender;
            this.panel = panel;
            iniciaEvento();
        }

        /*
         * Método inicializador del evento
         */
        public void iniciaEvento()
        {
            if (panel.getPantalla().Equals("0") || panel.getOp())
            {
                if (sender.Equals(","))
                {
                    if (!panel.getDecimal())
                    {
                        panel.setPantalla("0,");
                    }
                    panel.setDecimal(true);
                }
                else
                {
                    panel.setPantalla(sender);
                    panel.setDecimal(false);
                }
            }
            else
            {
                if(sender.Equals(","))
                {
                    if(!panel.getDecimal())
                    {
                        if(panel.getOp())
                        {
                            panel.setPantalla("0,");
                        }
                        else
                        {
                            panel.setPantalla(panel.getPantalla()+",");
                        }
                    }
                    panel.setDecimal(true);
                }
                else
                {
                    panel.setPantalla(panel.getPantalla()+sender);
                }
            }

            panel.setOp(false);
        }

    }
}
