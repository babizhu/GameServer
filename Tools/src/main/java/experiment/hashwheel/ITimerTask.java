/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package experiment.hashwheel;

/**
 * A task which is executed after the delay specified with
 * {@link ITimer#newTimeout(ITimerTask, long, java.util.concurrent.TimeUnit)}.
 */
public interface ITimerTask{

    /**
     * Executed after the delay specified with
     * {@link ITimer#newTimeout(ITimerTask, long, java.util.concurrent.TimeUnit)}.
     *
     * @param timeout a handle which is associated with this task
     */
    void run(ITimeout timeout) throws Exception;
}
