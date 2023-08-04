/**
 * Copyright 2015-2023 Kaitai Project: MIT license
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package io.kaitai.struct;

public class ConsistencyError extends RuntimeException {
    private final String id;
    private final Object actual;
    private final Object expected;

    public ConsistencyError(String id, Object actual, Object expected) {
        super("Check failed: " + id + ", expected: " + expected + ", actual: " + actual);

        this.id = id;
        this.actual = actual;
        this.expected = expected;
    }

    public String id() { return id; }
    public Object actual() { return actual; }
    public Object expected() { return expected; }

    public static class SizeMismatch extends ConsistencyError {
        public SizeMismatch(String id, long actual, long expected) {
            super(id, actual, expected);
        }
    }
}