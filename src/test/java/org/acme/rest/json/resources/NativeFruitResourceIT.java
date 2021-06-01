package org.acme.rest.json.resources;

import io.quarkus.test.junit.NativeImageTest;
import org.acme.rest.json.resources.FruitResourceTest;

@NativeImageTest
public class NativeFruitResourceIT extends FruitResourceTest {

    // Execute the same tests but in native mode.
}