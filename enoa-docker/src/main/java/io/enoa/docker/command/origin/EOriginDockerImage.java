/*
 * Copyright (c) 2018, enoa (fewensa@enoa.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.enoa.docker.command.origin;

import io.enoa.docker.dqp.image.*;
import io.enoa.docker.stream.DStream;

public interface EOriginDockerImage {

  default String list() {
    return this.list(null);
  }

  /**
   * List Images
   * Returns a list of images on the server. Note that it uses a different,
   * smaller representation of an image than inspecting a single image.
   *
   * @param dqp dqp
   * @return String
   */
  String list(DQPListImage dqp);

  /**
   * @see #build(DQPBuild, String, DStream)
   */
  default String build(DQPBuild dqp, String dockerfile) {
    return this.build(dqp, dockerfile, null);
  }

  /**
   * Build an image
   * Build an image from a tar archive with a Dockerfile in it.
   * <p>
   * The Dockerfile specifies how the image is built from the tar archive.
   * It is typically in the archive's root, but can be at a different path or have a different name
   * by specifying the dockerfile parameter. See the Dockerfile reference for more information.
   * <p>
   * The Docker daemon performs a preliminary validation of the Dockerfile before starting the build,
   * and returns an error if the syntax is incorrect. After that, each instruction is run one-by-one
   * until the ID of the new image is output.
   * <p>
   * The build is canceled if the client drops the connection by quitting or being killed.
   *
   * @param dqp        dqp
   * @param dockerfile dockerfile content
   * @param dstream    chunk
   * @return String
   */
  String build(DQPBuild dqp, String dockerfile, DStream<String> dstream);

  /**
   * Delete builder cache
   *
   * @return String
   */
  String prunebuild();


  /**
   * Create an image
   * Create an image by either pulling it from a registry or importing it.
   *
   * @param dqp  dqp
   * @param body request body
   * @return String
   */
  String create(DQPImageCreate dqp, String body);

  /**
   * Inspect an image
   * Return low-level information about an image.
   *
   * @param id string Required
   *           <p>
   *           Image name or id
   * @return string
   */
  String inspect(String id);

  /**
   * Get the history of an image
   * Return parent layers of an image.
   *
   * @param id string Required
   *           <p>
   *           Image name or ID
   * @return Stirng
   */
  String history(String id);

  /**
   * @see #push(String, DQPPush)
   */
  default String push(String id) {
    return this.push(id, null, null);
  }

  default String push(String id, DStream<String> dstream) {
    return this.push(id, null, dstream);
  }

  default String push(String id, DQPPush dqp) {
    return this.push(id, dqp, null);
  }

  /**
   * Push an image
   * Push an image to a registry.
   * <p>
   * If you wish to push an image on to a private registry, that image must already have a tag which references the registry.
   * For example, registry.example.com/myimage:latest.
   * <p>
   * The push is cancelled if the HTTP connection is closed.
   *
   * @param id  string Required
   *            <p>
   *            Image name or ID.
   * @param dqp dqp
   * @return String
   */
  String push(String id, DQPPush dqp, DStream<String> dstream);

  /**
   * Tag an image
   * Tag an image so that it becomes part of a repository.
   *
   * @param id  string Required
   *            <p>
   *            Image name or ID to tag.
   * @param dqp dqp
   * @return String
   */
  String tag(String id, DQPTag dqp);

  /**
   * @see #remove(String, DQPRmi)
   */
  default String remove(String id) {
    return this.remove(id, null);
  }

  /**
   * Remove an image
   * Remove an image, along with any untagged parent images that were referenced by that image.
   * <p>
   * Images can't be removed if they have descendant images, are being used by a running container or are being used by a build.
   *
   * @param id string Required
   *           <p>
   *           Image name or ID
   * @return String
   */
  String remove(String id, DQPRmi dqp);

  /**
   * Search images
   * Search for an image on Docker Hub.
   *
   * @param dqp dqp
   * @return String
   */
  String search(DQPSearch dqp);

  default String pruneimage() {
    return this.pruneimage(null);
  }

  /**
   * Delete unused images
   *
   * @return Stirng
   */
  String pruneimage(DQPPruneImage dqp);

  /**
   * @see #commit(String, DQPCommit)
   */
  default String commit(String body) {
    return this.commit(body, null);
  }

  /**
   * Create a new image from a container
   *
   * @param body The container configuration
   *             {
   *             "Hostname": "string",
   *             "Domainname": "string",
   *             "User": "string",
   *             "AttachStdin": false,
   *             "AttachStdout": true,
   *             "AttachStderr": true,
   *             "ExposedPorts": {
   *             "property1": {},
   *             "property2": {}
   *             },
   *             "Tty": false,
   *             "OpenStdin": false,
   *             "StdinOnce": false,
   *             "Env": [
   *             "string"
   *             ],
   *             "Cmd": [
   *             "string"
   *             ],
   *             "Healthcheck": {
   *             "Test": [
   *             "string"
   *             ],
   *             "Interval": 0,
   *             "Timeout": 0,
   *             "Retries": 0,
   *             "StartPeriod": 0
   *             },
   *             "ArgsEscaped": true,
   *             "Image": "string",
   *             "Volumes": {
   *             "property1": {},
   *             "property2": {}
   *             },
   *             "WorkingDir": "string",
   *             "Entrypoint": [
   *             "string"
   *             ],
   *             "NetworkDisabled": true,
   *             "MacAddress": "string",
   *             "OnBuild": [
   *             "string"
   *             ],
   *             "Labels": {
   *             "property1": "string",
   *             "property2": "string"
   *             },
   *             "StopSignal": "SIGTERM",
   *             "StopTimeout": 10,
   *             "Shell": [
   *             "string"
   *             ]
   *             }
   * @param dqp  dqp
   * @return String
   */
  String commit(String body, DQPCommit dqp);

}
