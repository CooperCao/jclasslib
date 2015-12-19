/*
    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    version 2 of the license, or (at your option) any later version.
*/

package org.gjt.jclasslib.bytecode

import org.gjt.jclasslib.io.ByteCodeInput
import org.gjt.jclasslib.io.ByteCodeOutput

import java.io.IOException

/**
 * Describes the multianewarray instruction.

 * @author [Ingo Kegel](mailto:jclasslib@ej-technologies.com)
 */
class MultianewarrayInstruction(opcode: Opcode) : ImmediateShortInstruction(opcode) {

    /**
     * Number of dimensions for the new array.
     */
    var dimensions: Int = 0

    override val size: Int
        get() = super.size + 1

    @Throws(IOException::class)
    override fun read(input: ByteCodeInput) {
        super.read(input)

        dimensions = input.readUnsignedByte()
    }

    @Throws(IOException::class)
    override fun write(output: ByteCodeOutput) {
        super.write(output)

        output.writeByte(dimensions)
    }

}
