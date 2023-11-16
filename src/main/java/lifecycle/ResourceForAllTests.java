/*
 * ========================================================================
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ========================================================================
 */

package lifecycle;

import java.io.PrintStream;

import space.jbpark.utility.MyUtil;

public class ResourceForAllTests {

    private String resourceName;
    private PrintStream ps = MyUtil.getPrintStream();

    public ResourceForAllTests(String resourceName) {
        this.resourceName = resourceName;
        ps.println(resourceName + " (소속 클래스: " + getClass().getSimpleName() + ") 초기화하고 있다.");
    }

    public void close() {
        ps.println(resourceName + " (소속 클래스: " + getClass().getSimpleName() + ") 폐쇄하고 있다.");
    }
}
