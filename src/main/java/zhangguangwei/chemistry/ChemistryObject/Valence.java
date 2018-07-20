package zhangguangwei.chemistry.ChemistryObject;


public class Valence {
        public String ChineseName;
        public String EnglishName;
        public String Valence;

        public Valence(String _Cn,String _En, String _Va){
            ChineseName=_Cn;
            EnglishName=_En;
            Valence=_Va;

        }
        public  Valence(String _cn){
            ChineseName=_cn;
        }

    public Valence(String _En, String _Va){

        EnglishName=_En;
        Valence=_Va;

    }
    }