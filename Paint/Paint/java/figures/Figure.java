package figures;
import ivisible.Ivisivel;
import java.awt.*;
import java.util.ArrayList;
import java.io.Serializable;
import javax.swing.JColorChooser;



public abstract class Figure implements Ivisivel,Serializable{
        protected int x;
      	protected int y;
      	protected int w;
      	protected int h;
        protected Color fundo;
        protected Color contorno;


       public abstract void print();
       public abstract void settSize(int dx, int dy,int hs);

    protected ArrayList<Rect> auxp = new ArrayList<Rect>();

    public void drag(int dx, int dy) {
        this.x = this.x + dx;
        this.y = this.y + dy;
        if(( this.x<= 80)){
            this.x=81;           
        }
    }
    
    
    public ArrayList<Rect> making_dots(){
        ArrayList<Rect> dots = new ArrayList<Rect>();
        int dot = 7;
        Rect O,NO,SO,N,S,NL,L,SL;
        NO = new Rect(this.x - dot,this.y - dot,dot,dot,Color.cyan,Color.black);
        dots.add(NO);
        N = new Rect((this.x)+(this.w)/2 - dot/2 , this.y - dot , dot, dot,Color.cyan,Color.black);
        dots.add(N);
        NL = new Rect((this.x)+(this.w)  , this.y - dot , dot, dot,Color.cyan,Color.black);
        dots.add(NL);
        O = new Rect(this.x - dot, (this.y)+((this.h))/2 - dot/2, dot, dot,Color.cyan,Color.black );
        dots.add(O);
        L = new Rect((this.x)+(this.w), (this.y)+(this.h)/2 - dot/2 , dot, dot, Color.cyan,Color.black );
        dots.add(L);
        SO = new Rect(this.x - dot, (this.y)+(this.h), dot, dot, Color.cyan,Color.black);
        dots.add(SO);
        S = new Rect((this.x)+(this.w)/2 - dot/2, (this.y)+(this.h) , dot, dot, Color.cyan,Color.black);
        dots.add(S);
        SL = new Rect((this.x)+(this.w), (this.y)+(this.h) , dot, dot, Color.cyan,Color.black);
        dots.add(SL);
        return dots;
        
    }
    public void mudarcordefundo(){
        JColorChooser colorChooser = new JColorChooser();
        this.fundo = JColorChooser.showDialog(null, "Escolha uma cor para o fundo da figura", Color.black);
    
    }
    
    public void mudarcordecontorno(){
        JColorChooser colorChooser = new JColorChooser();
        this.contorno = JColorChooser.showDialog(null, "Escolha uma cor para o contorno da figura", Color.black);
    
    }

    public void foculisedobj(Graphics g,ArrayList<Rect> dots){
        Graphics2D gdd = (Graphics2D) g;
        gdd.setStroke(new BasicStroke(1.5f));
        gdd.setColor(Color.black);
        gdd.drawRect((this.x),(this.y), (this.w),(this.h));
        for( Rect ponto: dots){
            gdd.setColor(ponto.contorno);
            gdd.drawRect(ponto.x, ponto.y, ponto.w, ponto.h);
            gdd.setColor(ponto.fundo);
            gdd.fillRect(ponto.x, ponto.y, ponto.w, ponto.h);
         }
    }
    
    public int handlerizar( Point mp){
        int hs= -1;
        for(Rect ao:auxp ){
            if((mp.x >= ao.x) && (mp.x<=((ao.x)+(ao.w))) && ((mp.y>= ao.y) && (mp.y<=(ao.y) + (ao.h)))){  
                hs=auxp.indexOf(ao);
                break;
            }
                           
            else{
                hs=-1;
            }                          
        }
        return hs;
    }
    
    public int get(String variavel){
        switch(variavel){
            case "w":{
                return this.w;
            }
            case "h":{
                return this.h;
            }
            case "x":{
                return this.x;
            }
            case "y":{
                return this.y;
            }
        }
      return 0;  
    }
}
