
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author derec
 */
public class Ball extends JPanel implements Runnable,IPrototype<Ball> {

        Color color;
        String ballcolor;
        int diameter;
        long delay;
        public int orientacion;
        private int vx;
        private int vy;

        public Ball(String ballcolor, int xvelocity, int yvelocity,int orient) {
            setLayout(null);
            if (ballcolor == "red") {
                color = Color.red;
            } else if (ballcolor == "blue") {
                color = Color.blue;
            } else if (ballcolor == "black") {
                color = Color.black;
            } else if (ballcolor == "cyan") {
                color = Color.cyan;
            } else if (ballcolor == "darkGray") {
                color = Color.darkGray;
            } else if (ballcolor == "gray") {
                color = Color.gray;
            } else if (ballcolor == "green") {
                color = Color.green;
            } else if (ballcolor == "yellow") {
                color = Color.yellow;
            } else if (ballcolor == "lightGray") {
                color = Color.lightGray;
            } else if (ballcolor == "magenta") {
                color = Color.magenta;
            } else if (ballcolor == "orange") {
                color = Color.orange;
            } else if (ballcolor == "pink") {
                color = Color.pink;
            } else if (ballcolor == "white") {
                color = Color.white;
            }
            diameter = 15;
            delay = 100;
            orientacion = orient;
            vx = xvelocity;
            vy = yvelocity;

            new Thread(this).start();

        }
        
        public String getBallColor() {
            return ballcolor;
        }
        
        public int getVX() {
            return vx;
        }
        
        public int getVY() {
            return vy;
        }
        
        public int getOrientation() {
            return orientacion;
        }
    
        public void setBallColor(String ballColor) {
            this.ballcolor = ballColor;
        }
        
        public void setVX(int vx) {
            this.vx = vx;
        }
        
        public void setVY(int vy) {
            this.vy = vy;
        }
        
        public void setOrientation(int orientacion) {
            this.orientacion = orientacion;
        }
        
        
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            int x = getX();
            int y = getY();

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(color);
            g.fillOval(0, 0, 10, 10); //agrega color al circulo
            g.setColor(Color.black);
            g2.drawOval(0, 0, 10, 10); //dibuja circulo
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(15, 15);
        }
        
        public void run() {
            
        }
        
       /*public void run() {

            try {
               
                SwingUtilities.invokeAndWait(new Runnable() {
                    @Override
                    public void run() {
                        int x = (int) (Math.round(Math.random() * getParent().getWidth()));
                        int y = (int) (Math.round(Math.random() * getParent().getHeight()));

                        setLocation(x, y);
                    }
                });
            } catch (InterruptedException exp) {
                exp.printStackTrace();
            } catch (InvocationTargetException exp) {
                exp.printStackTrace();
            }

            while (isVisible()) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                }

                try {
                    SwingUtilities.invokeAndWait(new Runnable() {
                        @Override
                        public void run() {
                            if(orientacion == 90){
                                move90();
                                repaint();
                            }
                            if(orientacion == 180){
                                move180();
                                repaint();
                            }
                            if(orientacion == 45){
                                move45();
                                repaint();
                            }
                        }
                    });
                } catch (InterruptedException exp) {
                    exp.printStackTrace();
                } catch (InvocationTargetException exp) {
                    exp.printStackTrace();
                }
            }
        }

        public void move180() {

            int x = getX();
            int y = getY();

            if (x + vx < 0 || x + diameter + vx > getParent().getWidth()) {
                vx *= -1;
            }
           
            x += vx;
           

            // Update the size and location...
            setSize(getPreferredSize());
            setLocation(x, y);
        }
        public void move90() {

            int x = getX();
            int y = getY();

            
            if (y + vy < 0 || y + diameter + vy > getParent().getHeight()) {
                vy *= -1;
            }
           
            y += vy;

            
            setSize(getPreferredSize());
            setLocation(x, y);

        }
        public void move45() {

            int x = getX();
            int y = getY();

            
            if (y + vy < 0 || y + diameter + vy > getParent().getHeight()) {
                vy *= -1;
            }
            if (x + vx < 0 || x + diameter + vx > getParent().getWidth()) {
                vx *= -1;
            }
           
            x += vx;
           
            y += vy;

            
            setSize(getPreferredSize());
            setLocation(x, y);

        } */

    @Override
    public Ball clone() {
        return new Ball(this.ballcolor,this.vx, this.vy,this.orientacion);
    }

    @Override
    public Ball deepClone() {
        return clone();
    }
    
    @Override
    public String toString() {
        String msj = "Ball = " + "color:" + ballcolor + ", vx=" + vx + ", vy "+ vy + "orientacion:" + orientacion; 
        return msj.toString();
    }
    
    
     public static void main(String[] args) {
        //Creamos la lista de bolitas inicial
        BallListImpl standardBolita = new BallListImpl("Bolita1");
        
        for(int c = 1; c<=5; c++){
            Ball item = new Ball("red",30,30,90);
            standardBolita.addProductItem(item);
        }
        // se agrega a la fabrica, al hash de protypes
        BallFactory.addPrototype(standardBolita.getBallName(), standardBolita);
       
        //Segunda lista de bolitas
        BallListImpl bolita2 = (BallListImpl) BallFactory.getPrototype("Bolita1");
        
        bolita2.setBallName("Bolita2");
        
        // cambia color
        for(Ball item : bolita2.getBalls()){
            item.setBallColor("blue");
        }           
        // agrega a la factory hash
        BallFactory.addPrototype(bolita2.getBallName(), bolita2);                      //Tercera lista de precios para clientes VIP a partir de la lista           //de mayoreo con 10% de descuento sobre la lista de precios de mayoreo.           PriceListImpl vipPriceList = (PriceListImpl)                   PrototypeFactory.getPrototype("Wholesale Price List");           vipPriceList.setListName("VIP Price List");           for(ProductItem item : vipPriceList.getProducts()){               item.setPrice(item.getPrice()*0.90);           }                      //Imprimimos las listas de precios.           System.out.println(standarPriceList);           System.out.println(wholesalePriceList);           System.out.println(vipPriceList);       }   }

        //Tercera lista de bolitas
        BallListImpl bolita3 = (BallListImpl) BallFactory.getPrototype("Bolita2");
        bolita3.setBallName("Bolita3");
        
        for(Ball item : bolita3.getBalls()){
            item.setBallColor("orange");
        }
          
        //Imprimimos las listas de bolitas
        System.out.println(standardBolita);
        System.out.println(bolita2);
        System.out.println(bolita3);     
     }
}
