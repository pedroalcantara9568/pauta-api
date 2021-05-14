package com.example.demo.schedule;

import com.example.demo.domain.Pauta;
import com.example.demo.service.KafkaProducerService;
import com.example.demo.service.PautaService;
import com.example.demo.service.ResultadoService;
import com.example.demo.web.rest.dto.ResultadoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static com.example.demo.shared.JsonUtil.toJson;

@Component
@EnableScheduling
public class PautaSchedule {

    private static final Logger logger = LoggerFactory.getLogger(PautaSchedule.class);

    private final PautaService pautaService;
    private final ResultadoService resultadoService;
    private final KafkaProducerService kafkaProducerService;

    @Autowired
    public PautaSchedule(PautaService pautaService,
                         ResultadoService resultadoService,
                         KafkaProducerService kafkaProducerService) {
        this.pautaService = pautaService;
        this.resultadoService = resultadoService;
        this.kafkaProducerService = kafkaProducerService;
    }

    @Scheduled(fixedDelay = 1000)
    public void fecharPautaCasoVerdadeiro() {
        pautaService.consultarPautasAbertas().stream()
                .filter(Pauta::estahFechadaIhNaoFoiEnviada).forEach(pauta -> {

            ResultadoDTO resultadoDTO = resultadoService.obterResultado(pauta.getId());

            logger.info("Enviando resultado :" + resultadoDTO);
            kafkaProducerService.writeMessage(toJson(resultadoDTO));

            logger.info("salvando pauta fechada :" + pauta);
            sinalizarEnvioPauta(pauta);
            pautaService.atualizarPauta(pauta);
        });
    }

    private void sinalizarEnvioPauta(Pauta pauta) {
        pauta.setEnviadoKafka(true);
    }
}
