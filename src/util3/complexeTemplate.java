package util3;


public class complexeTemplate<T> {


    private T _im;
    private T _re;

    //***************************************************************************************

    /*public  complexeTemplate()
    {_im=(T)0;   _re=0;}
    */
    public  complexeTemplate(T im,T re)
    {_im=im;    _re=re; }

    //***************************************************************************************
    //***************************************************************************************
    //***************************************************************************************

    public T    getIm()       {return _im;}
    public void setIm(T im)   {_im=im;}

    public T       getRe()            {return _re;}
    public void    setRe(T re)   {_re=re;}

    /*
    public complexeTemplate addition (complexeTemplate c2){
        T partiere = this._re + c2._re ;
        T partieim   = this._im + c2._im ;
        return new complexeTemplate(partiere, partieim);
    }

    public complexeTemplate multiplication(complexeTemplate C) {
        double partiere = (this._re * C._re - this._im * C._im);
        double partieim = (this._re * C._im - this._im * C._re);
        return new complexeTemplate(partiere, partieim);
    }
*/

    @Override    public boolean equals(Object obj) {        return super.equals(obj);    }
    @Override    public int hashCode() {        return super.hashCode();    }
    @Override    protected Object clone() throws CloneNotSupportedException {        return super.clone();    }
    @Override    protected void finalize() throws Throwable {        super.finalize();    }

   // @Override    public String toString() {        return "complexeTemplate{" +                "_im=" + _im +                ", _re=" + _re +                ", a=" + a +                ", complexeTemplate=" + complexeTemplate +                '}';    }

    /*
    <template T>
    public static complexeTemplate<T> operator+(complexeTemplate<T> a, complexeTemplate<T> b)
*/


}



