
package common;

public class UtilServiceImpl implements UtilService {

    private static UtilService instance = new UtilServiceImpl();
    private UtilServiceImpl(){}

    public static UtilService getInstance(){
        return instance;
    }


    @Override
    public int createRandomInteger(int start, int andEnd) {
        //초기값 start, 엔드값 andEnd
        return start + (int)(Math.random() * (andEnd-start));
    }

    @Override
    public double createRandomDouble(double start, double andEnd) {
        return Math.round((start + Math.random() * (andEnd-start)) * 10) / 10.0;
    }

    @Override
    public String createRandomName() {
        String[] names = {"이정재", "마동석", "송강호", "윤여정", "황정민", "정우성",
                "이병헌", "현  빈", "유해진", "손석구", "전도연", "손예진", "하지원",
                "김하늘", "송중기", "하정우", "장동건", "원 빈", "박해일", "소지섭", "김혜수"};
        return names[createRandomInteger(0,20)];
    }

    @Override
    public String createRandomTitles() {
        String[] titles = {
                "대한민국 헌법",
                "훈장등의 영전",
                "지역경제의 육성",
                "국회재의원",
                "Love your self",
                "Black swan",
                "run BTS",
                "지역 균형발전에 관하여",
                "Dyamite",
                "절차 및 기타 필요한 사항"
        };
        return titles[createRandomInteger(0,10)];
    }

    @Override
    public String createRandomMemberId() {
        String memberId = "";

        for(int i=0;i<5;i++) {
            memberId +=
                    String.valueOf(
                    (char)('a'+createRandomInteger(0,26)));
        }

        return memberId;
    }

    @Override
    public String createRandomAccount() {
        String randomAccount= "";
        for(int i=0;i<7;i++){
            randomAccount += String.valueOf(createRandomInteger(0,9));
        }
        return randomAccount;
    }

    @Override
    public String createRandomContents() {
        String[] contents = {
                "헌법 제1조 1항  대한민국은 민주공화국이다.",
                "헌법 제1조 2항 대한민국의 주권은 국민에게 있고, 모든 권력은 국민으로부터 나온다.",
                "헌법 제2조 1항 대한민국의 국민이 되는 요건은 법률로 정한다.",
                "국정감사 및 조사에 관한 절차 기타 필요한 사항은 법률로 정한다.",
                "훈장등의 영전은 이를 받은 자에게만 효력이 있고, 어떠한 특권도 이에 따르지 아니한다.",
                "대통령으로 선거될 수 있는 자는 국회의원의 피선거권이 있고 선거일 현재 40세에 달하여야 한다",
                "국가는 지역간의 균형있는 발전을 위하여 지역경제를 육성할 의무를 진다.",
                "대통령은 법률안의 일부에 대하여 또는 법률안을 수정하여 재의를 요구할 수 없다.",
                "Light it up like dynamite",
                "모든 빛이 침묵하는 바다,길 잃은 내 발목을 또 잡아, 어떤 소리도 들리지 않아",
        };
        return contents[createRandomInteger(0,10)];
    }

    @Override
    public String createRandomJob() {
        String[] names = {"경찰", "소방관", "세일즈맨", "교수", "회계사",
                "공무원", "의사"};
        return names[createRandomInteger(0,6)];
    }


}