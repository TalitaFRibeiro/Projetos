/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2;

import figures.*;
import ivisible.Ivisivel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


public class Button implements Ivisivel {
    
    Rectangle Botao;
    public int idx;//index
    private Figure fig;
    Random rand = new Random();
    
    

    public Button(int idx, Figure fig) {
        this.idx = idx;
        this.fig = fig;
        
    }
    
    public ArrayList<Figure> limpar_tudo(ArrayList<Figure> elementos){
        if(this.idx==5){
            elementos.removeAll(elementos);
        }
        return elementos;
    }
    
    
    public Figure Create_figurebtn(int xf, int yf){
        
        switch(this.idx){
        
            case 1:{
                int xp = xf;
                int yp = yf;
                int w = rand.nextInt(50);
		int h = rand.nextInt(50);
		Color fundo = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),255);
		Color contorno = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),255);
		Rect r = new Rect(xp,yp, w,h,fundo,contorno);                       
		
		r.print();
                return r;
            }
            case 2:{
                int xp = xf;
		int yp = yf;
		int w = rand.nextInt(50);
		int h = rand.nextInt(50);
		Color fundo = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256), 255 );
		Color contorno = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),255);
		Ellipse e = new Ellipse(xp,yp, w,h,fundo,contorno);                        
		
		e.print();
                return e;
            }
            case 3:{
                int xp = xf;
                int yp = yf;
                int h = rand.nextInt(50);
                int w = rand.nextInt(55) + 15;
                Color fundo = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),255);
                Color contorno = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),255);
                Triang t = new Triang(xp,yp, w,h,fundo,contorno);                         
                t.print();
                return t;
            }
            case 4:{
                int xp = xf;
                int yp = yf;
                int w = rand.nextInt(100);
                int h = rand.nextInt(50);
                Color fundo = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),255);
                Color contorno = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),255);
                Trapezio c = new Trapezio(xp,yp, w,h,fundo,contorno);                       
                
                c.print();
                return c;
            
            
            }

    }    
        return null;
       
    
    
    }
    


    
    @Override
    public boolean clicked(int x, int y){
        return Botao.contains(x, y);     
    }

    @Override
    public void paint(Graphics g, boolean focused) {
        Graphics2D gb = (Graphics2D) g;
        gb.setStroke(new BasicStroke(1.5f));
        Botao = new Rectangle(25,(this.idx)*50,50,50);
              if(focused==true){
                gb.setColor(Color.BLUE);
                gb.fill(Botao);
                gb.setColor(Color.black);
                gb.draw(Botao);
                
            
              }
              else{
                  gb.setColor(Color.LIGHT_GRAY);
                  gb.fill(Botao);
                  gb.setColor(Color.black);
                  gb.draw(Botao);
              
              }
        
         
            this.fig.paint(g, false);    
          }
      
            
            
          
        
        
        
        
        
        

}
    

