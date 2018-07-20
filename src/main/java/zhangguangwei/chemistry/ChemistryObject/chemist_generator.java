package zhangguangwei.chemistry.ChemistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class chemist_generator {
    private List<Valence> list_plus = new ArrayList<Valence>();
    private List<Valence> list_minus = new ArrayList<Valence>();

    public void initData() {
        list_plus.add(new Valence("Li", "+1"));
        list_plus.add(new Valence("K", "+1"));
        list_plus.add(new Valence("Na", "+1"));
        list_plus.add(new Valence("Ag", "+1"));
        list_plus.add(new Valence("Cu", "+2"));
        list_plus.add(new Valence("Ca", "+2"));
        list_plus.add(new Valence("Mg", "+2"));
        list_plus.add(new Valence("Ba", "+2"));
        list_plus.add(new Valence("Zn", "+2"));
        list_plus.add(new Valence("Fe", "+3"));
        list_plus.add(new Valence("Hg", "+2"));
        list_plus.add(new Valence("Al", "+3"));
        list_plus.add(new Valence("Fe", "+2"));
        list_plus.add(new Valence("NH4", "+1"));

        list_minus.add(new Valence("F", "-1"));
        list_minus.add(new Valence("Cl", "-1"));
        list_minus.add(new Valence("Br", "-1"));
        list_minus.add(new Valence("I", "-1"));
        list_minus.add(new Valence("OH", "-1"));
        list_minus.add(new Valence("HCO3", "-1"));
        list_minus.add(new Valence("NO3", "-1"));
        list_minus.add(new Valence("PO3", "-3"));
        list_minus.add(new Valence("O", "-2"));
        list_minus.add(new Valence("S", "-2"));
        list_minus.add(new Valence("SO4", "-2"));
        list_minus.add(new Valence("CO3", "-2"));
        list_minus.add(new Valence("SO3", "-2"));

    }

    public Valence RandomSummonPositive(){
        Random random = new Random();
        return list_plus.get(random.nextInt(13));
    }

    public Valence RandomSummonNegative(){
        Random random = new Random();
        return list_minus.get(random.nextInt(12));
    }

    public String Generator(Valence el_1, Valence el_2) {
        //el1= element 1 , el2 = element 2
        int temp1, temp2, el1_van, el2_van;
        String elt_1, elt_2;
        if (el_1 != null && el_2 != null) {
            el1_van = Integer.parseInt(el_1.Valence);
            el2_van = Integer.parseInt(el_2.Valence);
            if ((el1_van > 0 && el2_van > 0) || (el1_van < 0 && el2_van < 0)) {
                return "Error - 1";
            } else {
                temp1 = el1_van;
                temp2 = el2_van;
                gcd(temp1, temp2);
                el1_van = el1_van / gcd(temp1, temp2);
                el2_van = el2_van / gcd(temp1, temp2);
                elt_1 = ((isTuan(el_1))?"(":"") + el_1.EnglishName + ((isTuan(el_1))?")":"") + (abs(el2_van)==1 ? "":abs(el2_van));
                elt_2 = ((isTuan(el_2))?"(":"") + el_2.EnglishName + ((isTuan(el_2))?")":"") + (abs(el1_van)==1 ? "":abs(el1_van));
                if (el1_van > 0 && el2_van < 0) {
                    return elt_2 + elt_1;
                } else {
                    return elt_1 + elt_2;
                }
            }
        } else {
            return "error - 2";
        }

    }

    //https://blog.csdn.net/qqjjjaa11/article/details/77992831
    private static int gcd(int a, int b) {

        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;

    }


    private static int abs(int a) {
        if(a>0){
            return a;
        }else{
            return -a;
        }
    }

    private static boolean isTuan(Valence van){
        String str =van.EnglishName;
        int cntU = 0;
        int cntL = 0;
        int cntOther = 0;
        int i;
        for (i=0; i<str.length(); ++i){

                   char ch = str.charAt(i);
                   if(ch>='a' && ch<='z'){
                          cntL++;
                   }
                   else if (ch>='A' && ch<='Z'){
                          cntU++;
                   }
                   else{
                          cntOther++;
                   }
        }

        if(cntU>1 && Integer.parseInt(van.Valence)!=1){

            return true;
        }else{
            return false;
        }


    }






}
