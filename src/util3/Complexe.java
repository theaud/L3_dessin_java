package util3;


public class Complexe {

      private Double _im;
      private Double _re;
    
 //***************************************************************************************   
    
    public  Complexe()
    {_im=0.0;   _re=0.0;}
    public  Complexe(Double im,Double re)
    {_im=im;    _re=re; }

   //***************************************************************************************
   //*************************************************************************************** 
   //*************************************************************************************** 
    
    public Double getIm()            {return _im;}
    public void   setIm(Double im)   {_im=im;}
   
    public Double getRe()            {return _re;}
    public void   setRe(Double re)   {_re=re;}

    public Complexe addition (Complexe c2){
    double partiere = this._re + c2._re ;
    double partieim   = this._im + c2._im ;
    return new Complexe(partiere, partieim);
    }

    public Complexe multiplication(Complexe C) {
        double partiere = (this._re * C._re - this._im * C._im);
        double partieim = (this._re * C._im - this._im * C._re);
        return new Complexe(partiere, partieim);
    }



}