/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.etsf01.aesp.algo;

import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author wamai
 */
public class ParserTest {
    
    
    @Test
    public void testParsingWith4Projects()
    {
        String filePath = "test/se/etsf01/aesp/algo/test_data";
        Parser parser = new Parser(filePath);
        ProjectList projectList = parser.parseFile();
        
        Project project0 = projectList.get(0);
        Map<Attribute,Rating> attributes0 = project0.attributes();
        assertEquals(attributes0.get(Attribute.RELY), Rating.NOMINAL);
        assertEquals(attributes0.get(Attribute.DATA), Rating.HIGH);
        assertEquals(attributes0.get(Attribute.CPLX), Rating.VERY_HIGH);
        assertEquals(attributes0.get(Attribute.TIME), Rating.NOMINAL);
        assertEquals(attributes0.get(Attribute.STOR), Rating.NOMINAL);
        assertEquals(attributes0.get(Attribute.VIRT), Rating.LOW);
        assertEquals(attributes0.get(Attribute.TURN), Rating.NOMINAL);
        assertEquals(attributes0.get(Attribute.ACAP), Rating.HIGH);
        assertEquals(attributes0.get(Attribute.AEXP), Rating.NOMINAL);
        assertEquals(attributes0.get(Attribute.PCAP), Rating.VERY_HIGH);
        assertEquals(attributes0.get(Attribute.VEXP), Rating.LOW);
        assertEquals(attributes0.get(Attribute.LEXP), Rating.NOMINAL);
        assertEquals(attributes0.get(Attribute.MODP), Rating.HIGH);
        assertEquals(attributes0.get(Attribute.TOOL), Rating.NOMINAL);
        assertEquals(attributes0.get(Attribute.SCED), Rating.LOW);
        
        assertEquals(project0.getLinesOfCode(), 70000);
        assertEquals(project0.getActualEffort(), Effort
					.instantiatePersonMonths(278));
        
        Project project1 = projectList.get(1);
        Map<Attribute,Rating> attributes1 = project1.attributes();
        assertEquals(attributes1.get(Attribute.RELY), Rating.VERY_HIGH);
        assertEquals(attributes1.get(Attribute.DATA), Rating.HIGH);
        assertEquals(attributes1.get(Attribute.CPLX), Rating.HIGH);
        assertEquals(attributes1.get(Attribute.TIME), Rating.VERY_HIGH);
        assertEquals(attributes1.get(Attribute.STOR), Rating.VERY_HIGH);
        assertEquals(attributes1.get(Attribute.VIRT), Rating.NOMINAL);
        assertEquals(attributes1.get(Attribute.TURN), Rating.NOMINAL);
        assertEquals(attributes1.get(Attribute.ACAP), Rating.VERY_HIGH);
        assertEquals(attributes1.get(Attribute.AEXP), Rating.VERY_HIGH);
        assertEquals(attributes1.get(Attribute.PCAP), Rating.VERY_HIGH);
        assertEquals(attributes1.get(Attribute.VEXP), Rating.NOMINAL);
        assertEquals(attributes1.get(Attribute.LEXP), Rating.HIGH);
        assertEquals(attributes1.get(Attribute.MODP), Rating.HIGH);
        assertEquals(attributes1.get(Attribute.TOOL), Rating.HIGH);
        assertEquals(attributes1.get(Attribute.SCED), Rating.LOW);
        
        assertEquals(project1.getLinesOfCode(), 227000);
        assertEquals(project1.getActualEffort(), Effort
					.instantiatePersonMonths(1181));
        
        Project project2 = projectList.get(2);
        Map<Attribute,Rating> attributes2 = project2.attributes();
        assertEquals(attributes2.get(Attribute.RELY), Rating.NOMINAL);
        assertEquals(attributes2.get(Attribute.DATA), Rating.HIGH);
        assertEquals(attributes2.get(Attribute.CPLX), Rating.HIGH);
        assertEquals(attributes2.get(Attribute.TIME), Rating.VERY_HIGH);
        assertEquals(attributes2.get(Attribute.STOR), Rating.HIGH);
        assertEquals(attributes2.get(Attribute.VIRT), Rating.LOW);
        assertEquals(attributes2.get(Attribute.TURN), Rating.HIGH);
        assertEquals(attributes2.get(Attribute.ACAP), Rating.HIGH);
        assertEquals(attributes2.get(Attribute.AEXP), Rating.NOMINAL);
        assertEquals(attributes2.get(Attribute.PCAP), Rating.HIGH);
        assertEquals(attributes2.get(Attribute.VEXP), Rating.LOW);
        assertEquals(attributes2.get(Attribute.LEXP), Rating.HIGH);
        assertEquals(attributes2.get(Attribute.MODP), Rating.HIGH);
        assertEquals(attributes2.get(Attribute.TOOL), Rating.NOMINAL);
        assertEquals(attributes2.get(Attribute.SCED), Rating.LOW);
        
        assertEquals(177900, project2.getLinesOfCode());
        assertEquals(project2.getActualEffort(), Effort
					.instantiatePersonMonths(1248.0f));
        
        Project project3 = projectList.get(3);
        Map<Attribute,Rating> attributes3 = project3.attributes();
        assertEquals(attributes3.get(Attribute.RELY), Rating.HIGH);
        assertEquals(attributes3.get(Attribute.DATA), Rating.LOW);
        assertEquals(attributes3.get(Attribute.CPLX), Rating.HIGH);
        assertEquals(attributes3.get(Attribute.TIME), Rating.NOMINAL);
        assertEquals(attributes3.get(Attribute.STOR), Rating.NOMINAL);
        assertEquals(attributes3.get(Attribute.VIRT), Rating.LOW);
        assertEquals(attributes3.get(Attribute.TURN), Rating.LOW);
        assertEquals(attributes3.get(Attribute.ACAP), Rating.NOMINAL);
        assertEquals(attributes3.get(Attribute.AEXP), Rating.NOMINAL);
        assertEquals(attributes3.get(Attribute.PCAP), Rating.NOMINAL);
        assertEquals(attributes3.get(Attribute.VEXP), Rating.NOMINAL);
        assertEquals(attributes3.get(Attribute.LEXP), Rating.HIGH);
        assertEquals(attributes3.get(Attribute.MODP), Rating.HIGH);
        assertEquals(attributes3.get(Attribute.TOOL), Rating.NOMINAL);
        assertEquals(attributes3.get(Attribute.SCED), Rating.LOW);
        
        assertEquals(project3.getLinesOfCode(), 66600);
        assertEquals(project3.getActualEffort(), Effort
					.instantiatePersonMonths(352.8f));
    }
}
