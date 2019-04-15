package com.example.Meikkipussi;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Meikkipussi.domain.Category;
import com.example.Meikkipussi.domain.Meikki;
import com.example.Meikkipussi.domain.MeikkiRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MeikkiRepositoryTest {
	
	@Autowired
	private MeikkiRepository mrepository;
	
	@Test
    public void findByValmistajaShouldReturnMeikki() {
        List<Meikki> meikit = mrepository.findByValmistaja("Lumene");
        
        assertThat(meikit).hasSize(1);
        assertThat(meikit.get(0).getNimi()).isEqualTo("Nordic Chic irtopuuteri");
    }
    
    @Test
    public void createNewMeikki() {
    	Meikki meikki = new Meikki(1, "Shimmering Skin Perfector", "Becca", "0,28 Oz", "38€", new Category("Highlighter"));
    	mrepository.save(meikki);
    	assertThat(meikki.getId()).isNotNull();
    }
}
