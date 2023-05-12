package figures;
import java.awt.*;


public class Trapezio extends Figure{
    private Polygon trapezio;
    private int basemenor;

 	public Trapezio(int x,int y,int w,int h,Color fundo,Color contorno){
  		this.x=x;
  		this.y=y;
  		this.w=w;
  		this.h=h;
  		this.fundo=fundo;
  		this.contorno=contorno;
                basemenor = ((this.w)/2);
                
        }
	public void print() {
            System.out.format("Trapézio de tamanho (%d, base maior; %d, base menor;%d, altura) na posicao (%d,%d)\n",
                this.w,basemenor, this.h, this.x, this.y);
        }
	
	public void paint(Graphics g, boolean focused) {
		Graphics2D g2 = (Graphics2D) g;
		int[] xdir= {this.x,this.x,(this.w)+(this.x), basemenor + (this.x)};
		int[] ydir={this.y,(this.h) + (this.y),(this.h) + (this.y),this.y};
                trapezio = new Polygon(xdir,ydir,4);
		g2.setColor(this.fundo);
		g2.fillPolygon(trapezio);
		g2.setColor(this.contorno);
		g2.drawPolygon(trapezio);
                if(focused==true){
                    auxp=this.making_dots();
                    this.foculisedobj(g2, auxp);
                    
                }
	}

        public void settSize(int dx, int dy, int hs) {
            switch(hs){
            
                case 0: {//Quadrado NW
                    this.x =this.x + dx;
                    this.y= this.y + dy;
                    this.w = this.w - dx;
                    this.h = this.h - dy;
                    break;
                }
                case 1:{//Quadrado N

                    this.y=  this.y + dy;
                    this.h =  this.h - dy;
                    break;

                }
                case 2:{//Quadrado NE

                    this.y= this.y + dy;
                    this.w = this.w + dx;
                    this.h = this.h - dy;
                    break;
                }

                case 3:{//Quadrado W
                    this.x =this.x + dx;
                    this.w = this.w - dx;
                    break;
                }
                case 4:{//Quadrado E
                    this.w = this.w + dx;
                    break;
                }
                case 5:{//Quadrado SW
                        this.x =this.x + dx;
                        this.w = this.w - dx;
                        this.h = this.h + dy;
                        break;

                }
                case 6:{//Quadrado S
                    this.h = this.h + dy;
                    break;

                }
                case 7:{//Quadrado SE
                    this.w = this.w + dx;
                    this.h = this.h + dy;
                    break;
                }
                case 8:{// + ou - do teclado
                    this.w = this.w + dx;
                    this.h = this.h + dy;
                    break;
                }
            
            
            }
            //Configurando tamanho minimo
            if((this.w<=0)&&(this.h<=0)){
                this.w=5;
                this.h=5;
            }
            else if(this.h<=0){
                this.h=5;
            }
            else{
                if(this.w<=0){
                    this.w=5;
                }
            }   

            basemenor = (this.w)/2;
            
    }
    
    public boolean clicked (int x, int y){
        return trapezio.contains(x, y);
    }
        
}
