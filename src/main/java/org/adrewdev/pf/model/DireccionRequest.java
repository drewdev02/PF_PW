package org.adrewdev.pf.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DireccionRequest {
    private String provincia;
    private String municipio;
    private String calle;
    private String numero;
}
