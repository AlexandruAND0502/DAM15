

import com.example.demo.magazin.Instrument;
import com.example.demo.services.InstrumentService;
import com.example.demo.controller.InstrumentController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(InstrumentController.class)
public class InstrumentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InstrumentService instrumentService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateInstrument() throws Exception {
        Instrument instrument = new Instrument();
        instrument.setInstrumentName("Drum");
        instrument.setInstrumentState("New");

        when(instrumentService.save(Mockito.any(Instrument.class))).thenReturn(instrument);

        mockMvc.perform(post("/instruments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(instrument)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.instrumentName").value("Drum"));
    }

    @Test
    public void testGetInstrumentById() throws Exception {
        Instrument instrument = new Instrument();
        instrument.setInstrumentId(1L);
        instrument.setInstrumentName("Piano");

        when(instrumentService.findById(1L)).thenReturn(instrument);

        mockMvc.perform(get("/instruments/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.instrumentName").value("Piano"));
    }

    @Test
    public void testGetAllInstruments() throws Exception {
        Instrument instrument1 = new Instrument();
        instrument1.setInstrumentName("Flute");

        Instrument instrument2 = new Instrument();
        instrument2.setInstrumentName("Saxophone");

        when(instrumentService.findAll()).thenReturn(Arrays.asList(instrument1, instrument2));

        mockMvc.perform(get("/instruments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].instrumentName").value("Flute"))
                .andExpect(jsonPath("$[1].instrumentName").value("Saxophone"));
    }
}
