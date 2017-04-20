/**
 * 
 */
package mil.dtic.example.num;
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * Originally written by Jason Hunter, http://www.servlets.com.
 */

import java.io.Serializable;
import java.util.Random;

public class NumberGuessBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean resetRequired = true;
    private int answer;
    private String hint;
    private int numGuesses;
    private boolean success;
    private Random random = new Random();
    private final int lowNum = 1;
    private final int highNum = 2000;

    public NumberGuessBean() {
        if (resetRequired) {
            reset();
        }
    }

    public int getAnswer() {
        return answer;
    }

    private void setAnswer() {
        this.answer = random.nextInt(getHighNum() - getLowNum()) + 1 + getLowNum();
    }

    public String getHint() {
        return "" + hint;
    }

    private void setHint(String hint) {
        this.hint = hint;
    }

    private void setNumGuessesPlus1() {
        setNumGuesses(getNumGuesses()+1);
    }

    private void setNumGuesses(int numGuesses) {
        this.numGuesses = numGuesses;
    }

    public int getNumGuesses() {
        return numGuesses;
    }

    public boolean getSuccess() {
        return success;
    }

    private void setSuccess(boolean success) {
        this.success = success;
    }

    public void setGuess(String guess) {
        setNumGuessesPlus1();

        int g;
        try {
            g = Integer.parseInt(guess);
        }
        catch (NumberFormatException e) {
            g = -1;
        }

        if (g == answer) {
            setSuccess(true);
            setHint("Correct, good job!!!!!");
        }
        else if (g == -1) {
            setHint("a number next time");
        }
        else if (g < answer) {
            setHint("higher");
        }
        else if (g > answer) {
            setHint("lower");
        }
    }

    public int getLowNum() {
        return lowNum;
    }

    public int getHighNum() {
        return highNum;
    }

    public void reset() {
        setAnswer();
        setSuccess(false);
        setNumGuesses(0);
        setHint("");
        resetRequired=false;
    }
}
