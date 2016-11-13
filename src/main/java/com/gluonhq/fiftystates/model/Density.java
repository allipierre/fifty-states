/**
 * Copyright (c) 2016, Gluon
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *     * Neither the name of Gluon, any associated website, nor the
 * names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL GLUON BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.gluonhq.fiftystates.model;

/**
 *
 * Population Density (pop/km2)
 */
public class Density {

    public enum DENSITY {
        D000(0, 10),
        D010(10, 50),
        D050(50, 100),
        D100(100, 250),
        D250(250, 500),
        D500(500, 10000);

        final double ini;
        final double end;

        private DENSITY(double ini, double end){
            this.ini = ini;
            this.end = end;
        }

        public double getEnd() {
            return end;
        }

        public double getIni() {
            return ini;
        }

    }

    /**
     *
     * @param state
     * @return DENSITY category for the given US State
     */
    public static DENSITY getDensity (USState state) {
        return getDensity(state.getDensity());
    }

    /**
     *
     * @param density
     * @return DENSITY category for a given population density
     */
    public static DENSITY getDensity (double density) {
        for (DENSITY d : DENSITY.values()) {
            if (d.getIni() <= density && density < d.getEnd()) {
                return d;
            }
        }
        return DENSITY.D000;
    }
}
