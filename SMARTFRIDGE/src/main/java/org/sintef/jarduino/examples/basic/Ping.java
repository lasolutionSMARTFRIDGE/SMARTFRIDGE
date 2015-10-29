/**
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Authors: Franck Fleurey and Brice Morin
 * Company: SINTEF IKT, Oslo, Norway
 * Date: 2011
 */
package org.sintef.jarduino.examples.basic;

import org.sintef.jarduino.JArduino;
import org.sintef.jarduino.comm.Serial4JArduino;

/*
This example pings the arduino and outputs its response time
 */

public class Ping extends JArduino {

    public Ping(String port) {
        super(port);
    }

    @Override
    protected void setup() {
    }

    @Override
    protected void loop() {

        // store the current time
        long time = System.currentTimeMillis();
        // send the ping message to the arduino and wait for the pong message
        boolean alive = ping();
        // compute the time interval
        time = System.currentTimeMillis() - time;
        if (alive) {
            System.out.println("Reply from Arduino: time=" + time + "ms");
        } else {
            System.out.println("Request timed out (after " + time + "ms)");
        }
        delay(1000); // wait for a second
    }

    public static void main(String[] args) {
        String serialPort;
        if (args.length == 1) {
            serialPort = args[0];
        } else {
            serialPort = Serial4JArduino.selectSerialPort();
        }
        JArduino arduino = new Ping(serialPort);
        arduino.runArduinoProcess();
    }
}
