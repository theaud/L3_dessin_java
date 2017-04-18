/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util3;

/**
 *
 * @author mathieu
 */
public class ComplexeInt {
    
    
      private int _im;
      private int _re;  
    
 //***************************************************************************************   
    
    public  ComplexeInt()
    {_im=0;
     _re=0;   
    }
    public  ComplexeInt(int im,int re)
    {_im=im;
     _re=re;   
    }
   //***************************************************************************************
   //*************************************************************************************** 
   //*************************************************************************************** 

    /**
     *
     * @param size number of valu for the new table
     * @return a empty new table of int
     */
    public static ComplexeInt[] newTableComplexeInt(int size)
   {
       if(size>0)
       {ComplexeInt[] table=new ComplexeInt[size];
         for(int i=0;i<size;i++)
             { table[i]=new ComplexeInt(0,0); }
               
         return table; 
       }
       ComplexeInt[] table=new ComplexeInt[1];
      return table;
   
   }

    /**
     *
     * @return
     */
   public int getIm()            {return _im;}
   public void   setIm(int im)   {_im=im;}
   
   public int getRe()            {return _re;}    
   public void   setRe(int re)   {_re=re;} 
    
   public void set(int re,int im){_re=re;_im=im;}

    public ComplexeInt addition (ComplexeInt c2){
        int partiere = this._re + c2._re ;
        int partieim   = this._im + c2._im ;
        return new ComplexeInt(partiere, partieim);
    }

    public ComplexeInt multiplication(ComplexeInt C) {
        int partiere = (this._re * C._re - this._im * C._im);
        int partieim = (this._re * C._im - this._im * C._re);
        return new ComplexeInt(partiere, partieim);
    }
   
    
    
    
    
    
    
    
}
