package it.epicode.Pratica_S7_L2.prenotazioni;


import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    boolean existsByDipendenteIdAndDataRichiesta(Long dipendenteId, LocalDate dataRichiesta);

    void deleteAllByViaggioId(Long viaggioId);

    void deleteAllByDipendenteId(Long dipendenteId);



}