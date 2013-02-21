using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApplication1
{
    public partial class PanelCalculadora : Form
    {
        /*
         * Parámetros booleanos que controlarán posibles errores y operaciones dentro de la calculadora 
         */
        private bool op, dec, errDec;
        /*
         * Parámetro que ayudará a realizar las operaciones
         */
        private double aux;
        /*
         * Operación llevada a cabo
         */
        private String operacion;

        /*
         * Constructor principal de la calculadora que inicializa parámetros
         */
        public PanelCalculadora()
        {
            InitializeComponent();

            op = true;
            aux = 0.0;
            operacion = "";
            dec = false;
            errDec = false;

            /* Otra forma de enlazar los botones a eventos
             * btn0.Click += new System.EventHandler(btn_numeros);
             * btn1.Click += new System.EventHandler(btn_numeros);
             * btn2.Click += new System.EventHandler(btn_numeros);
             * btn3.Click += new System.EventHandler(btn_numeros);
             * btn4.Click += new System.EventHandler(btn_numeros);
             * btn5.Click += new System.EventHandler(btn_numeros);
             * btn6.Click += new System.EventHandler(btn_numeros);
             * btn7.Click += new System.EventHandler(btn_numeros);
             * btn8.Click += new System.EventHandler(btn_numeros);
             * btn9.Click += new System.EventHandler(btn_numeros);
             * btnDecimal.Click += new System.EventHandler(btn_numeros);
             * btnSuma.Click += new System.EventHandler(btn_operaciones);
             * btnResta.Click += new System.EventHandler(btn_operaciones);
             * btnMultiplica.Click += new System.EventHandler(btn_operaciones);
             * btnDivide.Click += new System.EventHandler(btn_operaciones);
             * btnSimbolo.Click += new System.EventHandler(btn_operaciones);
             * btnModulo.Click += new System.EventHandler(btn_operaciones);
             * btnIgual.Click += new System.EventHandler(btn_operaciones);
             */
        }

        /*
         * Maneja los eventos de los números
         * @param sender objeto que le pasamos al constructor de la clase 
         * ControladorNumerico, ademas de pasarle la clase que lo llama
         * @param e argumento del evento)
         */
        public void btn_numeros(object sender, EventArgs e)
        {
            if (tamPantalla() < 16 || op)
            {
                new ControladorNumerico(((Button)sender).Text, this);
            }
            btnIgual.Focus();
        }

        /*
         * Maneja los eventos de las operaciones
         * @param sender objeto que le pasamos al constructor de la clase 
         * ControladorOperaciones, ademas de pasarle la clase que lo llama
         * @param e argumento del evento)
         */
        private void btn_operaciones(object sender, EventArgs e)
        {
            new ControladorOperaciones(((Button)sender).Text, this);
            btnIgual.Focus();
        }

        /*
         * Modifica el valor dentro de la pantalla
         * @param s String que se pasa para modificar el valor de la pantalla
         */
        public void setPantalla(String s)
        {
            pantalla.Text = s;
        }

        /*
         * @return devuelve un String con el contenido de la pantalla
         */
        public String getPantalla()
        {
            return pantalla.Text;
        }

        /*
         * @return devuelve un bool que comprueba si se está llevando a cabo una operación
         */
        public bool getOp()
        {
            return op;
        }

        /*
         * Modifica el parámetro del decimal que indica si se ha añadido un decimal ya o no
         * @param flag bool que modifica el valor dec
         */
        public void setDecimal(bool flag)
        {
            dec = flag;
        }

        /*
         * @return devuelve un bool indicando si se ha pulsado el botón decimal
         */
        public bool getDecimal()
        {
            return dec;
        }

        /*
         * Modifica el parámetro que condiciona el estado de una operacion
         * @param flag bool que modifica el valor op
         */
        public void setOp(bool flag)
        {
            op = flag;
        }

        /*
         * @return devuelve un double con el contenido del valor auxiliar
         */
        public double getAux()
        {
            return aux;
        }

        /*
         * Modifica el valor auxiliar de la operación que ayudará a operar
         * @param aux double que modifica el valor aux
         */
        public void setAux(double aux)
        {
            this.aux = aux;
        }

        /*
         * @return boolean que controla el error decimal
         */
        public bool getErrDecimal()
        {
            return errDec;
        }

        /*
         * Modifica el control de error decimal
         * @param flag modifica el valor errDec
         */
        public void setErrDecimal(bool flag)
        {
            errDec = flag;
        }

        /*
         * Modifica la operación llevada a cabo
         * @param op String modifica el valor operación
         */
        public void setOperacion(String op)
        {
            operacion = op;
        }

        /*
         * @return String que devuelve la operación llevada a cabo
         */
        public String getOperacion()
        {
            return operacion;
        }

        /*
         * Método que controla los eventos capturados por teclado
         * @param sender object
         * @param e KeyPressEventArgs que controla los eventos por teclado
         */
        private void teclado_evento(object sender, KeyPressEventArgs e)
        {
            if (tamPantalla() < 16 || op)
            {
                if (e.KeyChar.Equals('0') || e.KeyChar.Equals('1') || e.KeyChar.Equals('2') ||
                    e.KeyChar.Equals('3') || e.KeyChar.Equals('4') || e.KeyChar.Equals('5') ||
                    e.KeyChar.Equals('6') || e.KeyChar.Equals('7') || e.KeyChar.Equals('8') ||
                    e.KeyChar.Equals('9') || e.KeyChar.Equals(','))
                {
                    new ControladorNumerico(e.KeyChar.ToString(), this);
                }
            }
            if (e.KeyChar.Equals('+') || e.KeyChar.Equals('-') || e.KeyChar.Equals('*') || 
                e.KeyChar.Equals('/') || e.KeyChar.Equals('%') || e.KeyChar.Equals('='))
            {
                new ControladorOperaciones(e.KeyChar.ToString(), this);
            }
            btnIgual.Focus();
        }

        /*
         * @return int que devuelve el tamaño del texto de la pantalla
         */
        public int tamPantalla()
        {
            return pantalla.Text.Length;
        }

        private void btnIgual_Enter(object sender, EventArgs e)
        {
            Console.WriteLine(e.ToString());

            new ControladorOperaciones("=", this);
        }
    }
}
