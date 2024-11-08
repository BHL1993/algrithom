package risk;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author ：BaiHailong
 * @date ：Created in 2023/8/15 10:29 上午
 */
public class Client {
    public static void main(String[] args) {

        int[] height = new int[]{1,1};

        int preIndex = 0;
        int lastIndex = height.length-1;
        int area = 0;


        while(preIndex < lastIndex){
            if(height[preIndex] <= height[lastIndex]){
                int t_area = (lastIndex-preIndex)*height[preIndex];
                if(t_area > area){
                    area = t_area;
                }
                preIndex++;

            }
            else{
                int t_area = (lastIndex-preIndex)*height[lastIndex];
                if(t_area > area){
                    area = t_area;
                }
                lastIndex--;

            }
        }
        System.out.println(area);
    }

    public static List<Predict> getPredictList() {
        List<Predict> ret = JSON.parseArray("[{\"label\":1,\t\"prob\":0.041997202}\n" +
                "{\"label\":1,\t\"prob\":0.019813435}\n" +
                "{\"label\":1,\t\"prob\":0.024855038}\n" +
                "{\"label\":1,\t\"prob\":0.059553757}\n" +
                "{\"label\":1,\t\"prob\":0.025160767}\n" +
                "{\"label\":1,\t\"prob\":0.046872485}\n" +
                "{\"label\":1,\t\"prob\":0.047734093}\n" +
                "{\"label\":1,\t\"prob\":0.033257663}\n" +
                "{\"label\":1,\t\"prob\":0.041519258}\n" +
                "{\"label\":1,\t\"prob\":0.084876612}\n" +
                "{\"label\":1,\t\"prob\":0.031850852}\n" +
                "{\"label\":1,\t\"prob\":0.043427441}\n" +
                "{\"label\":1,\t\"prob\":0.024086094}\n" +
                "{\"label\":1,\t\"prob\":0.014100409}\n" +
                "{\"label\":1,\t\"prob\":0.037231661}\n" +
                "{\"label\":1,\t\"prob\":0.026608435}\n" +
                "{\"label\":1,\t\"prob\":0.095683582}\n" +
                "{\"label\":1,\t\"prob\":0.057406951}\n" +
                "{\"label\":1,\t\"prob\":0.032200571}\n" +
                "{\"label\":1,\t\"prob\":0.036255695}\n" +
                "{\"label\":1,\t\"prob\":0.033092018}\n" +
                "{\"label\":1,\t\"prob\":0.115268208}\n" +
                "{\"label\":1,\t\"prob\":0.060115006}\n" +
                "{\"label\":1,\t\"prob\":0.022272063}\n" +
                "{\"label\":0,\t\"prob\":0.100051701}\n" +
                "{\"label\":0,\t\"prob\":0.042814992}\n" +
                "{\"label\":0,\t\"prob\":0.032901477}\n" +
                "{\"label\":0,\t\"prob\":0.046807539}\n" +
                "{\"label\":0,\t\"prob\":0.032047998}\n" +
                "{\"label\":0,\t\"prob\":0.077017561}\n" +
                "{\"label\":0,\t\"prob\":0.039585814}\n" +
                "{\"label\":0,\t\"prob\":0.059777763}\n" +
                "{\"label\":0,\t\"prob\":0.017092703}\n" +
                "{\"label\":0,\t\"prob\":0.057946052}\n" +
                "{\"label\":0,\t\"prob\":0.038372193}\n" +
                "{\"label\":0,\t\"prob\":0.045130555}\n" +
                "{\"label\":0,\t\"prob\":0.030800231}\n" +
                "{\"label\":0,\t\"prob\":0.048791785}\n" +
                "{\"label\":0,\t\"prob\":0.036152735}\n" +
                "{\"label\":0,\t\"prob\":0.042184994}\n" +
                "{\"label\":0,\t\"prob\":0.052329659}\n" +
                "{\"label\":0,\t\"prob\":0.16366674}\n" +
                "{\"label\":0,\t\"prob\":0.029690374}\n" +
                "{\"label\":0,\t\"prob\":0.062868327}\n" +
                "{\"label\":0,\t\"prob\":0.048462898}\n" +
                "{\"label\":0,\t\"prob\":0.068309881}\n" +
                "{\"label\":0,\t\"prob\":0.078079462}\n" +
                "{\"label\":0,\t\"prob\":0.086138025}\n" +
                "{\"label\":0,\t\"prob\":0.080951855}\n" +
                "{\"label\":0,\t\"prob\":0.034834646}\n" +
                "{\"label\":0,\t\"prob\":0.029173778}\n" +
                "{\"label\":0,\t\"prob\":0.050138231}\n" +
                "{\"label\":0,\t\"prob\":0.061895482}\n" +
                "{\"label\":0,\t\"prob\":0.026081813}\n" +
                "{\"label\":0,\t\"prob\":0.065577991}\n" +
                "{\"label\":0,\t\"prob\":0.028721189}\n" +
                "{\"label\":0,\t\"prob\":0.036854748}\n" +
                "{\"label\":0,\t\"prob\":0.083513305}\n" +
                "{\"label\":0,\t\"prob\":0.057407815}\n" +
                "{\"label\":0,\t\"prob\":0.060853921}\n" +
                "{\"label\":0,\t\"prob\":0.074092001}\n" +
                "{\"label\":0,\t\"prob\":0.063695423}\n" +
                "{\"label\":0,\t\"prob\":0.047349095}\n" +
                "{\"label\":0,\t\"prob\":0.03467707}\n" +
                "{\"label\":0,\t\"prob\":0.066923335}\n" +
                "{\"label\":0,\t\"prob\":0.053155813}\n" +
                "{\"label\":0,\t\"prob\":0.054851931}\n" +
                "{\"label\":0,\t\"prob\":0.035166115}\n" +
                "{\"label\":0,\t\"prob\":0.047300234}\n" +
                "{\"label\":0,\t\"prob\":0.066434503}\n" +
                "{\"label\":0,\t\"prob\":0.010571525}\n" +
                "{\"label\":0,\t\"prob\":0.086945936}\n" +
                "{\"label\":0,\t\"prob\":0.038808376}\n" +
                "{\"label\":0,\t\"prob\":0.048366856}\n" +
                "{\"label\":0,\t\"prob\":0.033403546}\n" +
                "{\"label\":0,\t\"prob\":0.050864566}\n" +
                "{\"label\":0,\t\"prob\":0.024656907}\n" +
                "{\"label\":0,\t\"prob\":0.041396741}\n" +
                "{\"label\":0,\t\"prob\":0.078059942}\n" +
                "{\"label\":0,\t\"prob\":0.078995027}\n" +
                "{\"label\":0,\t\"prob\":0.032034166}\n" +
                "{\"label\":0,\t\"prob\":0.05466193}\n" +
                "{\"label\":0,\t\"prob\":0.024172818}\n" +
                "{\"label\":0,\t\"prob\":0.047307566}\n" +
                "{\"label\":0,\t\"prob\":0.164072439}\n" +
                "{\"label\":0,\t\"prob\":0.071581788}\n" +
                "{\"label\":0,\t\"prob\":0.069813289}\n" +
                "{\"label\":0,\t\"prob\":0.149002373}\n" +
                "{\"label\":0,\t\"prob\":0.041560452}\n" +
                "{\"label\":0,\t\"prob\":0.034956727}\n" +
                "{\"label\":0,\t\"prob\":0.035593372}\n" +
                "{\"label\":0,\t\"prob\":0.059228875}\n" +
                "{\"label\":0,\t\"prob\":0.037936427}\n" +
                "{\"label\":0,\t\"prob\":0.074931294}\n" +
                "{\"label\":0,\t\"prob\":0.086513706}\n" +
                "{\"label\":0,\t\"prob\":0.043978255}\n" +
                "{\"label\":0,\t\"prob\":0.023226935}\n" +
                "{\"label\":0,\t\"prob\":0.068832941}\n" +
                "{\"label\":0,\t\"prob\":0.057089619}\n" +
                "{\"label\":0,\t\"prob\":0.184182078}\n" +
                "{\"label\":0,\t\"prob\":0.031264465}\n" +
                "{\"label\":0,\t\"prob\":0.033222549}\n" +
                "{\"label\":0,\t\"prob\":0.088323653}\n" +
                "{\"label\":0,\t\"prob\":0.054370139}\n" +
                "{\"label\":0,\t\"prob\":0.031449314}\n" +
                "{\"label\":0,\t\"prob\":0.023769481}\n" +
                "{\"label\":0,\t\"prob\":0.046646021}\n" +
                "{\"label\":0,\t\"prob\":0.039460916}\n" +
                "{\"label\":0,\t\"prob\":0.056574289}\n" +
                "{\"label\":0,\t\"prob\":0.022982134}\n" +
                "{\"label\":0,\t\"prob\":0.035799257}\n" +
                "{\"label\":0,\t\"prob\":0.044360805}\n" +
                "{\"label\":0,\t\"prob\":0.039606959}\n" +
                "{\"label\":0,\t\"prob\":0.108806282}\n" +
                "{\"label\":0,\t\"prob\":0.127740517}\n" +
                "{\"label\":0,\t\"prob\":0.039259687}\n" +
                "{\"label\":0,\t\"prob\":0.077965453}\n" +
                "{\"label\":0,\t\"prob\":0.051686082}\n" +
                "{\"label\":0,\t\"prob\":0.059446}\n" +
                "{\"label\":0,\t\"prob\":0.019073021}\n" +
                "{\"label\":0,\t\"prob\":0.04412457}\n" +
                "{\"label\":0,\t\"prob\":0.100496843}\n" +
                "{\"label\":0,\t\"prob\":0.054771755}\n" +
                "{\"label\":0,\t\"prob\":0.026308689}\n" +
                "{\"label\":0,\t\"prob\":0.050608445}\n" +
                "{\"label\":0,\t\"prob\":0.040417079}\n" +
                "{\"label\":0,\t\"prob\":0.039679028}\n" +
                "{\"label\":0,\t\"prob\":0.060771391}\n" +
                "{\"label\":0,\t\"prob\":0.062034581}\n" +
                "{\"label\":0,\t\"prob\":0.03266383}\n" +
                "{\"label\":0,\t\"prob\":0.072008125}\n" +
                "{\"label\":0,\t\"prob\":0.141226217}\n" +
                "{\"label\":0,\t\"prob\":0.094268359}\n" +
                "{\"label\":0,\t\"prob\":0.057612769}\n" +
                "{\"label\":0,\t\"prob\":0.039560247}\n" +
                "{\"label\":0,\t\"prob\":0.046409227}\n" +
                "{\"label\":0,\t\"prob\":0.035205696}\n" +
                "{\"label\":0,\t\"prob\":0.041421887}\n" +
                "{\"label\":0,\t\"prob\":0.037234675}\n" +
                "{\"label\":0,\t\"prob\":0.048052233}\n" +
                "{\"label\":0,\t\"prob\":0.049239442}\n" +
                "{\"label\":0,\t\"prob\":0.050431743}\n" +
                "{\"label\":0,\t\"prob\":0.053431358}\n" +
                "{\"label\":0,\t\"prob\":0.130451173}\n" +
                "{\"label\":0,\t\"prob\":0.055077087}\n" +
                "{\"label\":0,\t\"prob\":0.087548949}\n" +
                "{\"label\":0,\t\"prob\":0.106834613}\n" +
                "{\"label\":0,\t\"prob\":0.020557292}\n" +
                "{\"label\":0,\t\"prob\":0.047285713}\n" +
                "{\"label\":0,\t\"prob\":0.017474694}\n" +
                "{\"label\":0,\t\"prob\":0.066440575}\n" +
                "{\"label\":0,\t\"prob\":0.022639908}\n" +
                "{\"label\":0,\t\"prob\":0.050803393}\n" +
                "{\"label\":0,\t\"prob\":0.028098049}\n" +
                "{\"label\":0,\t\"prob\":0.021451559}\n" +
                "{\"label\":0,\t\"prob\":0.089495942}\n" +
                "{\"label\":0,\t\"prob\":0.08214926}\n" +
                "{\"label\":0,\t\"prob\":0.047080517}\n" +
                "{\"label\":0,\t\"prob\":0.072973169}\n" +
                "{\"label\":0,\t\"prob\":0.097140945}\n" +
                "{\"label\":0,\t\"prob\":0.058133252}\n" +
                "{\"label\":0,\t\"prob\":0.045634285}\n" +
                "{\"label\":0,\t\"prob\":0.038749877}\n" +
                "{\"label\":0,\t\"prob\":0.127547801}\n" +
                "{\"label\":0,\t\"prob\":0.045671858}\n" +
                "{\"label\":0,\t\"prob\":0.053269681}\n" +
                "{\"label\":0,\t\"prob\":0.07397905}\n" +
                "{\"label\":0,\t\"prob\":0.038835526}\n" +
                "{\"label\":0,\t\"prob\":0.043017361}\n" +
                "{\"label\":0,\t\"prob\":0.198002279}\n" +
                "{\"label\":0,\t\"prob\":0.030069113}\n" +
                "{\"label\":0,\t\"prob\":0.051950041}\n" +
                "{\"label\":0,\t\"prob\":0.047224887}\n" +
                "{\"label\":0,\t\"prob\":0.013934558}\n" +
                "{\"label\":0,\t\"prob\":0.048280586}\n" +
                "{\"label\":0,\t\"prob\":0.060549542}\n" +
                "{\"label\":0,\t\"prob\":0.097416304}\n" +
                "{\"label\":0,\t\"prob\":0.115351379}\n" +
                "{\"label\":0,\t\"prob\":0.053906538}\n" +
                "{\"label\":0,\t\"prob\":0.06276384}\n" +
                "{\"label\":0,\t\"prob\":0.138933927}\n" +
                "{\"label\":0,\t\"prob\":0.034359053}\n" +
                "{\"label\":0,\t\"prob\":0.048107348}\n" +
                "{\"label\":0,\t\"prob\":0.051653184}\n" +
                "{\"label\":0,\t\"prob\":0.044412527}\n" +
                "{\"label\":0,\t\"prob\":0.045208137}\n" +
                "{\"label\":0,\t\"prob\":0.032311685}\n" +
                "{\"label\":0,\t\"prob\":0.097143367}\n" +
                "{\"label\":0,\t\"prob\":0.182218879}\n" +
                "{\"label\":0,\t\"prob\":0.039892226}\n" +
                "{\"label\":0,\t\"prob\":0.149695158}\n" +
                "{\"label\":0,\t\"prob\":0.036884993}\n" +
                "{\"label\":0,\t\"prob\":0.091223828}\n" +
                "{\"label\":0,\t\"prob\":0.026748909}\n" +
                "{\"label\":0,\t\"prob\":0.060031932}\n" +
                "{\"label\":0,\t\"prob\":0.031794388}\n" +
                "{\"label\":0,\t\"prob\":0.082449064}\n" +
                "{\"label\":0,\t\"prob\":0.083087638}\n" +
                "{\"label\":0,\t\"prob\":0.152424857}\n" +
                "{\"label\":0,\t\"prob\":0.087034747}\n" +
                "{\"label\":0,\t\"prob\":0.040135946}\n" +
                "{\"label\":0,\t\"prob\":0.052185766}\n" +
                "{\"label\":0,\t\"prob\":0.0507918}\n" +
                "{\"label\":0,\t\"prob\":0.032346763}\n" +
                "{\"label\":0,\t\"prob\":0.14707163}\n" +
                "{\"label\":0,\t\"prob\":0.048843849}\n" +
                "{\"label\":0,\t\"prob\":0.084314369}\n" +
                "{\"label\":0,\t\"prob\":0.072329082}\n" +
                "{\"label\":0,\t\"prob\":0.093195051}\n" +
                "{\"label\":0,\t\"prob\":0.065268993}\n" +
                "{\"label\":0,\t\"prob\":0.153108001}\n" +
                "{\"label\":0,\t\"prob\":0.035891995}\n" +
                "{\"label\":0,\t\"prob\":0.069071218}\n" +
                "{\"label\":0,\t\"prob\":0.073437154}\n" +
                "{\"label\":0,\t\"prob\":0.056421157}\n" +
                "{\"label\":0,\t\"prob\":0.075917616}\n" +
                "{\"label\":0,\t\"prob\":0.247193113}\n" +
                "{\"label\":0,\t\"prob\":0.076328337}\n" +
                "{\"label\":0,\t\"prob\":0.047009215}\n" +
                "{\"label\":0,\t\"prob\":0.11111667}\n" +
                "{\"label\":0,\t\"prob\":0.02857291}\n" +
                "{\"label\":0,\t\"prob\":0.118079521}\n" +
                "{\"label\":0,\t\"prob\":0.09080302}\n" +
                "{\"label\":0,\t\"prob\":0.051145505}\n" +
                "{\"label\":0,\t\"prob\":0.050236896}\n" +
                "{\"label\":0,\t\"prob\":0.044366799}\n" +
                "{\"label\":0,\t\"prob\":0.044865899}\n" +
                "{\"label\":0,\t\"prob\":0.040991545}\n" +
                "{\"label\":0,\t\"prob\":0.04859769}\n" +
                "{\"label\":0,\t\"prob\":0.046564199}\n" +
                "{\"label\":0,\t\"prob\":0.077950858}\n" +
                "{\"label\":0,\t\"prob\":0.049650006}\n" +
                "{\"label\":0,\t\"prob\":0.038000345}\n" +
                "{\"label\":0,\t\"prob\":0.049268138}\n" +
                "{\"label\":0,\t\"prob\":0.017822077}\n" +
                "{\"label\":0,\t\"prob\":0.102000408}\n" +
                "{\"label\":0,\t\"prob\":0.035042766}\n" +
                "{\"label\":0,\t\"prob\":0.0758541}\n" +
                "{\"label\":0,\t\"prob\":0.038453806}\n" +
                "{\"label\":0,\t\"prob\":0.045864817}\n" +
                "{\"label\":0,\t\"prob\":0.040154304}\n" +
                "{\"label\":0,\t\"prob\":0.057072964}\n" +
                "{\"label\":0,\t\"prob\":0.020946015}\n" +
                "{\"label\":0,\t\"prob\":0.024662923}\n" +
                "{\"label\":0,\t\"prob\":0.072159059}\n" +
                "{\"label\":0,\t\"prob\":0.030462377}\n" +
                "{\"label\":0,\t\"prob\":0.064247258}\n" +
                "{\"label\":0,\t\"prob\":0.071272321}\n" +
                "{\"label\":0,\t\"prob\":0.039145906}\n" +
                "{\"label\":0,\t\"prob\":0.032579027}\n" +
                "{\"label\":0,\t\"prob\":0.114624657}\n" +
                "{\"label\":0,\t\"prob\":0.058010083}\n" +
                "{\"label\":0,\t\"prob\":0.04306484}\n" +
                "{\"label\":0,\t\"prob\":0.050110575}\n" +
                "{\"label\":0,\t\"prob\":0.043854933}\n" +
                "{\"label\":0,\t\"prob\":0.01785031}\n" +
                "{\"label\":0,\t\"prob\":0.049110919}\n" +
                "{\"label\":0,\t\"prob\":0.099457227}\n" +
                "{\"label\":0,\t\"prob\":0.031849504}\n" +
                "{\"label\":0,\t\"prob\":0.049071025}\n" +
                "{\"label\":0,\t\"prob\":0.172248006}\n" +
                "{\"label\":0,\t\"prob\":0.0369487}\n" +
                "{\"label\":0,\t\"prob\":0.039187253}\n" +
                "{\"label\":0,\t\"prob\":0.040163558}\n" +
                "{\"label\":0,\t\"prob\":0.072555803}\n" +
                "{\"label\":0,\t\"prob\":0.059485555}\n" +
                "{\"label\":0,\t\"prob\":0.059684105}\n" +
                "{\"label\":0,\t\"prob\":0.068109356}\n" +
                "{\"label\":0,\t\"prob\":0.085873723}\n" +
                "{\"label\":0,\t\"prob\":0.036288515}\n" +
                "{\"label\":0,\t\"prob\":0.085294746}\n" +
                "{\"label\":0,\t\"prob\":0.066585898}\n" +
                "{\"label\":0,\t\"prob\":0.059573811}\n" +
                "{\"label\":0,\t\"prob\":0.029879741}\n" +
                "{\"label\":0,\t\"prob\":0.01825197}\n" +
                "{\"label\":0,\t\"prob\":0.045824442}\n" +
                "{\"label\":0,\t\"prob\":0.060233839}\n" +
                "{\"label\":0,\t\"prob\":0.031857092}\n" +
                "{\"label\":0,\t\"prob\":0.059036758}\n" +
                "{\"label\":0,\t\"prob\":0.071537092}\n" +
                "{\"label\":0,\t\"prob\":0.069304965}\n" +
                "{\"label\":0,\t\"prob\":0.010693178}\n" +
                "{\"label\":0,\t\"prob\":0.15173997}\n" +
                "{\"label\":0,\t\"prob\":0.103844129}\n" +
                "{\"label\":0,\t\"prob\":0.034599457}\n" +
                "{\"label\":0,\t\"prob\":0.118845232}\n" +
                "{\"label\":0,\t\"prob\":0.028736675}\n" +
                "{\"label\":0,\t\"prob\":0.120906852}\n" +
                "{\"label\":0,\t\"prob\":0.097959898}\n" +
                "{\"label\":0,\t\"prob\":0.059744921}\n" +
                "{\"label\":0,\t\"prob\":0.074186191}\n" +
                "{\"label\":0,\t\"prob\":0.045887619}\n" +
                "{\"label\":0,\t\"prob\":0.05890312}\n" +
                "{\"label\":0,\t\"prob\":0.024312634}\n" +
                "{\"label\":0,\t\"prob\":0.05076018}\n" +
                "{\"label\":0,\t\"prob\":0.055577099}\n" +
                "{\"label\":0,\t\"prob\":0.046753805}\n" +
                "{\"label\":0,\t\"prob\":0.036106024}\n" +
                "{\"label\":0,\t\"prob\":0.022143181}\n" +
                "{\"label\":0,\t\"prob\":0.033907663}\n" +
                "{\"label\":0,\t\"prob\":0.054931823}\n" +
                "{\"label\":0,\t\"prob\":0.056611128}\n" +
                "{\"label\":0,\t\"prob\":0.066060379}\n" +
                "{\"label\":0,\t\"prob\":0.097348019}\n" +
                "{\"label\":0,\t\"prob\":0.039351787}\n" +
                "{\"label\":0,\t\"prob\":0.069549426}\n" +
                "{\"label\":0,\t\"prob\":0.251330405}\n" +
                "{\"label\":0,\t\"prob\":0.063916892}]", Predict.class);

        ret.sort(Comparator.comparingDouble(Predict::getProb));

        return ret;
    }
}
